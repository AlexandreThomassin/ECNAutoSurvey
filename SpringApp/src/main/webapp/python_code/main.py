# first_gui.py

import PySimpleGUI as sg
import os.path
from report_generation import generateReports

jsonFolderPath=""

# Normalize the data if necessary
json_cleaning(jsonFolderPath, "temp_normalizedJSON")
jsonFolderPath = "temp_normalizedJSON"

# Recover the data and initialize the metadata
surveyData = getSurveyData(jsonFolderPath)
courseTable = pd.read_csv("course_table.csv")
sectionTable = pd.read_csv("section_table.csv")
metaData = pd.DataFrame(columns = ['courseName', 'completeAnswerRate', 'partialAnswerRate', 'nbGoodPoints', 'nbBadPoints', 'globalQuality'])

# Get the good and bad positive rates
averageGoodPositiveRate, averageBadPositiveRate = 0, 0
lenSurveyData = 0
for courseCode in surveyData:
    if (verifyCourse(courseCode, courseTable)):
        nbStudents = getNbStudents(courseCode, courseTable)
        addRatesInfo(surveyData[courseCode], nbStudents)
        goodPositiveRate, badPositiveRate = getGoodBadPositiveRates(surveyData[courseCode], minAnswerRate, minGoodPositiveRate, maxBadPositiveRate)
        averageGoodPositiveRate += goodPositiveRate
        averageBadPositiveRate += badPositiveRate
        lenSurveyData += 1
goodPositiveRate = max(round(averageGoodPositiveRate / max(lenSurveyData,1)), minGoodPositiveRate)
badPositiveRate = min(round(averageBadPositiveRate / max(lenSurveyData,1)), maxBadPositiveRate)

# Generate the reports
count = 1
for courseCode in surveyData:
    if (verifyCourse(courseCode, courseTable)):
        print(count, courseCode, "yes")
        closedQuestions = {key: question for key, question in surveyData[courseCode].items() if question['isClosed']}
        openQuestions = {key: question for key, question in surveyData[courseCode].items() if not(question['isClosed'])}

        graphs = getGraphs(closedQuestions)
        nbStudents = getNbStudents(courseCode, courseTable)
         # Get the information on the course
    year, cursus, acronym = getCourseInfo(courseCode, courseTable)
    
    # Create the heading
    displayCourseInfo(document, acronym, "INGE", str(year), cursus)

    # Create the response rate section
    completeAnswerRate, partialAnswerRate = generateResponseRateSection(closedQuestions, document, nbStudents)

    # Create the evaluation sections
    nbGoodPoints, nbBadPoints = generatePositiveRatesSections(document, closedQuestions, minAnswerRate, goodPositiveRate, badPositiveRate, maxNbGoodBadPoints)

    # Create the table with the questions
    generateQuestionsTable(document, closedQuestions, graphs, sectionTable)

    # Create the open questions section
    generateOpenQuestionsSection(document, openQuestions)

    # Save the document in the output folder
    document.save(f"{outputFolder}/INGE_{year}_{getCursusCode(cursus)}_{acronym}_V0.docx")

    # Save the metadata
    metaData.loc[len(metaData.index)] = [acronym, completeAnswerRate, partialAnswerRate, nbGoodPoints, nbBadPoints, getGlobalQualityPositiveRate(closedQuestions)]

    else:
        print(count, courseCode, "no")
    count += 1
    # if count > 5:
    #     break

# Complete and save the metadata
metaData.loc[len(metaData.index)] = ['Average'] + list(metaData.mean(numeric_only=True))
metaData.to_csv(f"{outputFolder}/metaAnalysis.csv", index=False)