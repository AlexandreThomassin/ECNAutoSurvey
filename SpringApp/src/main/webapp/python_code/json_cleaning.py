"""
This code is for cleaning and transforming a set of survey data stored as JSON files.
The aim is to modify the questions in each file so that they conform to a specific format and to store the cleaned data in a new folder.

The data processing involves:
    1. Reading the JSON files using the 'jsonToDataframe' function from the 'read_json' module
    2. Treating and transforming the questions in each file so that they conform to a specific format
    3. Storing the cleaned data in a new folder

Attributes:
    CHOICE_QUESTIONS_DICT (dict): Dictionary of choice questions and their corresponding type code.
    CLOSED_ANSWERS (list): List of possible closed answers.
"""


import pandas as pd
import os
from read_json import jsonToDataframe
import re

# Dictionnary of choice questions and their corresponding type
CHOICE_QUESTIONS_DICT = {
    "Votre LVC (Langue Vivante Choisie) est :": 'CLCSS',
    "Votre LVO (Langue Vivante Obligatoire) est :":'CLOSS',
    "Votre Cours Court au Choix du Semestre 5 est :":'CCCS5'
}


# List of possible closed answers
CLOSED_ANSWERS = ["Pas du tout d'accord", "Plutôt pas d'accord", "Plutôt d'accord", "Tout à fait d'accord", "Tout à faire d'accord", "Sans avis, ne s'applique pas", ""]
    

def get_json_dataframes(folder_path):
    """
    Extract survey data from JSON files in the specified folder and convert it to a dict of pandas dataframes.
    Parameters:
        folder_path (str): The path to the folder containing the JSON files.

    Returns:
        dict: A dictionary of pandas dataframes, with filenames as keys.
    """

    file_df_dict = {}
    for filename in os.listdir(folder_path):
        if filename.endswith(".json"):
            file_path = os.path.join(folder_path, filename)
            file_df_dict[filename] = jsonToDataframe(file_path)
    return file_df_dict


def get_question_subject(question_text, type_code):
    """
    Get the subject of a survey question.
    Parameters:
        question_text (str): The text of the survey question.
        type_code (str): The type code of the question, either "CLOSQ", "OPENQ", or "SPECQ".

    Returns:
        str: The subject of the question.

    """
    if type_code == 'CLOSQ':
        l = question_text.split("[")
        if len(l) > 1 and l[0] != " ":
            if ":" in l[1]:
                return l[1].split( " :" )[0]
            return l[1].replace("]", "")
        else:
            return "Project"
    elif type_code == 'OPENQ':
        return question_text.split(" : ", 1)[0]
    elif type_code == 'SPECQ':
        return question_text.split("[")[1].strip().split( " :" )[0]


def add_prefix(question_text, course_code, section_code, type_code, index):
    """
    Add a standardized prefix to a survey question.

    Parameters:
        question_text (str): The text of the survey question.
        course_code (str): The code of the course associated with the question.
        section_code (str): The code of the section associated with the question.
        type_code (str): The type code of the question, either "CLOSQ", "OPENQ", or "SPECQ".
        index (int): An index used to distinguish similar questions.

    Returns:
        str: The prefixed survey question text.

    """
    return f"{course_code}{section_code}{type_code}{index:03}-{question_text}"


def get_unique_subjects(questions, type_code):

    """
    Given a list of questions and a type code, returns a dictionary of unique subjects in the questions with their values initialized to 0

    Parameters:
       questions (list): list of questions
       type_code (str): string representing the type of questions
    Returns:
        dict : dictionary of unique subjects and their values initialized to 0
   """


    unique_subjects = {}
    for question in questions:
        subject = get_question_subject(question, type_code)
        if subject not in unique_subjects and subject != "Project":
            unique_subjects[subject] = 0
    return unique_subjects


def get_question_type(answers):
    """
    Given a list of answers, returns the type of question
    Parameters:
       answers (str): single answer

    Returns:
        str : string representation of the question type ('OPENQ' for open question, 'CLOSQ' for closed question)
    """
    for answer in answers:
        if answer not in CLOSED_ANSWERS:
            return 'OPENQ'
    return 'CLOSQ'


def treat_information_questions(questions, general_questions):
    """
    Given a list of questions, returns a new list of questions with the new question texts

    Parameters:
       questions (list): list of questions
       general_questions (list): list of general questions

    Returns:
        list : list of tuples where each tuple contains the original question and the new question text
    """
    new_questions = []
    for k, question in enumerate(questions):
        if question in CHOICE_QUESTIONS_DICT:
            type_code = CHOICE_QUESTIONS_DICT[question]
            if type_code == "CLCSS":
                for general_question in general_questions:
                    match_LVC = re.match(r".*\[LVC_S(?P<semester>\d)\].*", general_question)
                    if not(match_LVC is None):
                        type_code = f"CLCS{match_LVC.group('semester')}"
                        break
            if type_code == "CLOSS":
                for general_question in general_questions:
                    match_LVO = re.match(r".*\[LVO_S(?P<semester>\d)\].*", general_question)
                    if not(match_LVO is None):
                        type_code = f"CLOS{match_LVO.group('semester')}"
                        break
        else:
            type_code = "XXXXX"
        new_question = add_prefix(question, "XXXXXXXX", "XXXX", type_code, k)
        new_questions.append([question, new_question])
    return new_questions


def treat_questions(questions, course_code_dict, quest_sect_dict,type_code, projectName):
    """
    This function takes in a list of questions, a course code dictionary, a question section dictionary and the type code of the questions.
    It returns a list of lists, each inner list containing the original question and its transformed version.

    Parameters:
        questions (list): A list of questions to be transformed
        course_code_dict (dict): A dictionary that maps a course subject to its code
        quest_sect_dict (dict): A dictionary that maps a question to its section code
        type_code (str): The type code of the questions

    Returns:
        list: A list of lists, each inner list containing the original question and its transformed version.

    """

    # Initialize an empty list to store the new list of questions
    new_questions = []

    # Get all the unique subjects and add them to a dict with a value of 0
    unique_subjects = get_unique_subjects(questions, type_code)
    if (projectName != ""):
        unique_subjects[projectName] = 0

    # Get the new questions texts
    for question in questions:

        # Get the subject of the current question
        subject = get_question_subject(question, type_code)
        if "Project" in subject:
            subject = projectName

        # If the question has a subject we can handle

        course_code = course_code_dict[subject]
        
        # Get the section code
        section_code = "XXXX"

        if question.split(" [")[0] in quest_sect_dict.keys():
            section_code = quest_sect_dict[question.split(" [")[0]]

        # Create the new question text and add it to the new questions list
        new_question = add_prefix(question, course_code, section_code, type_code, unique_subjects[subject])
        new_questions.append([question, new_question])
        unique_subjects[subject] += 1

    # Return the new list of questions
    return new_questions


def treat_specific_questions(questions, course_code_dict, survey_df):

    """
    This function takes in a list of questions, a dict of course codes, and a survey dataframe,
    and returns a list of tuples containing the original question text and its corresponding new question text.
    For questions with a specific course, it uses the course code to generate the new question text.
    For questions without a specific course, it uses the data from the survey dataframe to determine the course code.


    Parameters:
        questions (list): List of questions to be treated.
        course_code_dict (dict): Dict of course codes, with the course name as the key and the code as the value.
        survey_df (pd.DataFrame): Dataframe containing the survey data.

    Returns:
        list: List of tuples, each containing the original question text and its corresponding new question text.
    """

    # Initialize an empty list to store the new list of questions
    new_questions = []

    # Get all the unique subjects and add them to a dict with a value of 0
    unique_subjects = get_unique_subjects(questions, "SPECQ")

    # Get the list of course acronyms


    for question in questions:
        try:
            # Get the subject of the current question
            subject = get_question_subject(question, "SPECQ")

            course_code = course_code_dict[subject]


            # Get the section code
            section_code = "XXXX"

            # Get the question type (some of the specific questions are open)
            type_code = get_question_type(survey_df[question])

            # Create the new question text and add it to the new questions list
            new_question = add_prefix(question, course_code, section_code, type_code, unique_subjects[subject])
            new_questions.append([question, new_question])
            unique_subjects[subject] += 1
        except:
            continue

    # Return the new list of questions
    return new_questions


# Final function

def json_cleaning(initial_folder_path, final_folder_path):
    """
   This function takes as input the initial folder path where the raw json data is stored and the final folder path where the cleaned json data will be stored.
   It performs several operations on the raw data to clean it, standardize it and store it in the final folder path.

   Parameters:
    initial_folder_path (str): The path of the folder where the raw json data is stored
    final_folder_path (str): The path of the folder where the cleaned json data will be stored

   Returns:
    None
   """

    survey_df_dict = get_json_dataframes(initial_folder_path)

    courseTable = pd.read_csv("course_table.csv")
    courseTable = courseTable[['acronym','surveyCode']]
    course_code_dict = courseTable.set_index('acronym').squeeze("columns").to_dict()

    #course_code_dict = pd.read_csv('sujet_code_jsonclean.csv',index_col=0).squeeze("columns").to_dict()
    quest_sect_dict = pd.read_csv('Section_JSONclean.csv',index_col=0).squeeze("columns").to_dict()

    for filename, survey_df in survey_df_dict.items():

        # Columns list to be used to identify specific, open and closed questions for treatment
        questions = survey_df.columns.to_list()

        # Questions lists according to specific format on column heading
        specific_questions = [q for q in questions if 'spécifique' in q]
        not_specific_questions = [q for q in questions if not 'spécifique' in q]
        general_questions = [q for q in not_specific_questions if '[' in q]
        open_questions = [q for q in not_specific_questions if 'Propositions' in q or 'Points' in q]
        information_questions = [k for k in questions if not ('Propositions' in k or  'Points' in k or  '[' in k)]

        # Getting project

        projectName = ""
        for q in open_questions:
            if "Projet" in q:
                projectName = q.split()[0]
                break
        
        # Treat each type of questions depending on its type
        new_general_questions = treat_questions(general_questions, course_code_dict,quest_sect_dict, "CLOSQ", projectName)
        new_information_questions = treat_information_questions(information_questions, general_questions)
        new_specific_questions = treat_specific_questions(specific_questions, course_code_dict, survey_df)
        new_open_questions = treat_questions(open_questions, course_code_dict,quest_sect_dict, "OPENQ", projectName)
        
        # Rename the columns of the dataframe with the new names
        concatlist = new_specific_questions + new_open_questions + new_general_questions + new_information_questions
        for i in concatlist:
            survey_df.rename(columns = {i[0]: i[1]}, inplace=True)

        # write json data to file in specific directory
        json_data = '{"responses":' + survey_df.to_json(orient='records') + '}'
        path = os.path.join(final_folder_path, filename)
        with open(path, 'w') as file:
            file.write(json_data)