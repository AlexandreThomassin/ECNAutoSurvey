import json
import pandas as pd
import os
import re


# CONVERT JSON TO DATAFRAME

def jsonToDataframe(jsonPath):
    """
    Reads a json file and converts it to a Pandas dataframe.

    Parameters
    ----------
    jsonPath : string
        The path to the json file.

    Returns
    -------
    out : dataframe
        The dataframe created from the json file.
    """
    with open(jsonPath) as data_file:
        data = json.load(data_file)
    return pd.json_normalize(data, "responses")


# CONVERT DATAFRAME TO DICT STRUCTURE

def getCoursesColumns(answers):
    """
    Gets the list of columns names grouped by course.

    Parameters
    ----------
    answers : dataframe
        The dataframe containing the answers to the survey.

    Returns
    -------
    out : dict
        A dictionnary containing the columns for each course. The keys are the 
        courses codes and the values are lists of columns names.
    """
    coursesCodes = {}
    for col in answers.columns:
        colID = col[:20]
        courseCode = colID[:8]
        if courseCode != "XXXXXXXX":
            if not(courseCode in coursesCodes):
                coursesCodes[courseCode] = []
            coursesCodes[courseCode].append(col)  
    return coursesCodes


def isChoiceCourse(courseCode):
    """
    Checks if a course code matches a choice course (courses that the student 
    chose in one of the first questions).

    Parameters
    ----------
    courseCode : string
        The code of the course.

    Returns
    -------
    out : boolean
        If True, the course is a choice course.
    """
    typeTable = pd.read_csv("type_table.csv")
    return courseCode[:5] in typeTable['type'].values


def getMatchingChoiceCourseCode(choiceCourseName):
    """
    Gets the mathing course code for a given choice course name.

    Parameters
    ----------
    choiceCourseName : string
        The name of the choice course.

    Returns
    -------
    out : string
        The course code.

    Raises
    ------
    ValueError
        If choiceCourseName is not in the table. 
    """
    courseTable = pd.read_csv("course_table.csv")
    if not(choiceCourseName in courseTable['choiceCode'].to_list()):
        raise ValueError(f'The choice course name "{choiceCourseName}" is not in the table of courses names.')
    return courseTable.loc[courseTable['choiceCode'] == choiceCourseName]['surveyCode'].iloc[0]


def getChoiceCourseCodes(answers, choiceQuestionCode):
    """
    Gets the list of course code for the courses chosen in the choice question 
    with given code.

    Parameters
    ----------
    answers : dataframe
        The dataframe containing the answers to the survey.
    choiceQuestionCode : string
        The code of the choice question.

    Returns
    -------
    out : tuple of a string and a dict of strings
        The code of the choice question and the dict of courses where the keys 
        are the courses codes and the values are the courses names.
    """
    for col in answers.columns:
        colID = col.split('-')[0]
        questionTypeCode = colID[12:16]
        if questionTypeCode == choiceQuestionCode:
            choiceCourseCodes = {}
            for choiceCourseName in answers[col].unique():
                if not(choiceCourseName is None):
                    courseCode = getMatchingChoiceCourseCode(choiceCourseName)
                    choiceCourseCodes[courseCode] = choiceCourseName
            return col, choiceCourseCodes
    return '', {}


def splitCoursesAnswers(answers):
    """
    Splits the course answers by course code. The choice course are separated in several dataframes.

    Parameters
    ----------
    answers : dataframe
        The dataframe containing the answers to the survey.

    Returns
    -------
    out : dict of dataframes
        A dictionnary containing the courses answers. The keys are the course 
        codes and the values are dataframe containing the answers for that course.
    """
    # Initialize the dataframe dictionnary
    coursesAnswers = {}
    
    # Get the columns for every course
    coursesColumns = getCoursesColumns(answers)

    # Handle the choice course first
    courseCodesToRemove = set()
    nbNotSpecificQuestions = 0
    for courseCode in coursesColumns:
        if isChoiceCourse(courseCode):
            courseCodesToRemove.add(courseCode)
            nbNotSpecificQuestions = len(coursesColumns[courseCode])
            choiceQuestionCode, choiceCourseCodes = getChoiceCourseCodes(answers, courseCode[:4])
            for choiceCourseCode in choiceCourseCodes:
                choiceCourseAnswers = answers.loc[answers[choiceQuestionCode] == choiceCourseCodes[choiceCourseCode]]
                if choiceCourseCode in coursesColumns:
                    courseAnswers = choiceCourseAnswers[coursesColumns[courseCode] + coursesColumns[choiceCourseCode]]
                else:
                    courseAnswers = choiceCourseAnswers[coursesColumns[courseCode]]
                coursesAnswers[choiceCourseCode] = courseAnswers
    
    # Remove the already processed course codes
    for courseCode in courseCodesToRemove:
        coursesColumns.pop(courseCode)
    
    # Handle the other courses
    elseCourses = []
    for courseCode, courseColumns in coursesColumns.items():
        if len(courseColumns) >= nbNotSpecificQuestions:
            coursesAnswers[courseCode] = answers[courseColumns]
        else:
            if courseCode not in coursesAnswers:
                coursesAnswers[courseCode] = answers[courseColumns]
    return coursesAnswers


def getClosedQuestionAnswers(questionColumn):
    """
    Counts the different types of answers for a closed question.

    Parameters
    ----------
    questionColumn : series
        A column of answers to a closed question.

    Returns
    -------
    out : list
        A list containing the number of answers of each type.
    """
    answers = {"Pas du tout d'accord": 0, "Plutôt pas d'accord": 0, "Plutôt d'accord": 0, "Tout à fait d'accord": 0, "Sans avis, ne s'applique pas": 0, "": 0}
    for row in questionColumn:
        if row == "Tout à faire d'accord":
            answers["Tout à fait d'accord"] += 1
        else:
            answers[row] += 1
    return list(answers.values())


def cleanQuestionText(questionText):
    """
    Cleans the text of a question by removing unnecessary information.

    Parameters
    ----------
    questionText : string
        The text of the question
    
    Results
    -------
    out : string
        The text of the question without unnecessary information.
    """
    matchSpecificQuestion = re.match(r"Merci de répondre (également|aussi) ?(aux|à ces|à la) questions? spécifiques?( suivantes?)? : \[.* \: (?P<q>.*)\]", questionText)
    if not(matchSpecificQuestion is None):
        return matchSpecificQuestion.group('q')
    matchClosedQuestion = re.match(r"(?P<q>.*) \[.*\]", questionText)
    if not(matchClosedQuestion is None) and matchClosedQuestion.group('q').strip() != "":
        return matchClosedQuestion.group('q')
    matchOpenQuestion = re.match(r".* : (?P<q>.*)", questionText)
    if not(matchOpenQuestion is None):
        return matchOpenQuestion.group('q')
    matchProjQuestion = re.match(r" \[(?P<q>.*)\]", questionText)
    if not(matchProjQuestion is None):
        return matchProjQuestion.group('q')
    return questionText


def getCourseSurveyData(answers):
    """
    Converts the answers dataframe to the survey data structure.

    Parameters
    ----------
    answers : dataframe
        The dataframe containing the answers to the survey.

    Returns
    -------
    out : dict
        A dictionnary containing all the courses questions and their answers. 
        The keys are the courses codes and the values are dictionnaries of questions.
    """
    courseSurveyData = {}
    for col in answers.columns:
        questionID = col[:20]
        questionType = questionID[12:17]
        isClosed = (questionType == 'CLOSQ')
        if questionType in {'CLOSQ', 'OPENQ'}:
            if isClosed:
                questionAnswer = getClosedQuestionAnswers(answers[col])
            else:
                questionAnswer = [ans for ans in answers[col] if ans != ""]
            questionText = cleanQuestionText(col[21:])
            courseSurveyData[questionID] = {'isClosed': isClosed, 'question': questionText, 'answer': questionAnswer, 'section': questionID[8:12]}
    return courseSurveyData


# CONVERT JSON TO DICT STRUCTURE

def jsonToDict(jsonPath):
    """
    Reads a json file and converts it to the survey data structure.

    Parameters
    ----------
    jsonPath : string
        The path to the json file.

    Returns
    -------
    out : dict
        A dictionnary containing all the courses questions and their answers. 
        The keys are the courses codes and the values are dictionnaries of questions.
    """
    answers = jsonToDataframe(jsonPath)
    coursesAnswers = splitCoursesAnswers(answers)
    surveyDict = {}
    for courseName, courseAnswers in coursesAnswers.items():
        surveyDict[courseName] = getCourseSurveyData(courseAnswers)
    return surveyDict


# COMBINE MULTIPLE DICT STRUCTURES

def combineCourseQuestions(questions1, questions2):
    """
    Combines two questions in one. The questions must be the same, the only 
    difference is the answers.

    Parameters
    ----------
    questions1 : dict
        A dictionnary representing a question.
    questions2 : dict
        A dictionnary representing a question.

    Returns
    -------
    out : dict
        A dictionnary representing the combined questions.
    """
    for key, question in questions1.items():
        if key in questions2:
            if question['isClosed']:
                question['answer'] = [a1 + a2 for a1, a2 in zip(question['answer'], questions2[key]['answer'])]
            else:
                question['answer'] += questions2[key]['answer']


def concatenateSurveyDicts(surveyDicts):
    """
    Concatenates several survey data structures in one.

    Parameters
    ----------
    surveyDicts : list of dict
        A list of survey data dictionnaries.

    Returns
    -------
    out : dict
        A dictionnary containing all the courses questions and their answers. 
        The keys are the courses codes and the values are dictionnaries of questions.
    """
    finalDict = surveyDicts[0].copy()
    for d in range(1, len(surveyDicts)):
        surveyDict = surveyDicts[d]
        for key, courseQuestions in surveyDict.items():
            if key in finalDict:
                combineCourseQuestions(finalDict[key], courseQuestions)
            else:
                finalDict[key] = courseQuestions.copy()
    return finalDict
            

# COMBINE ALL THE JSON OF A FOLDER IN ONE DICT STRUCTURE

def getSurveyData(jsonFolderPath):
    """
    Reads all the json files in a folder and converts them to one survey data 
    structure.

    Parameters
    ----------
    jsonFolderPath : string
        The path to the json folder.

    Returns
    -------
    out : dict
        A dictionnary containing all the courses questions and their answers. 
        The keys are the courses codes and the values are dictionnaries of questions.
    """
    jsonPaths = [file for file in os.listdir(jsonFolderPath) if file.endswith(".json")]
    surveyDicts = [jsonToDict(f"{jsonFolderPath}/{jsonPath}") for jsonPath in jsonPaths]
    surveyData = concatenateSurveyDicts(surveyDicts)
    return surveyData