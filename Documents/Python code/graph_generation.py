"""
This code is used to generate the graphs in the report.
It converts a dictionary containing the questions with the percentage of each 
answer to stacked bar graphs.

Attributes:
    COLORS : dict
        List containing the colors given to the bars.
"""
import matplotlib.pyplot as plt
import matplotlib
from io import BytesIO


# List containing the colors given to the bars
COLORS = ['#FF0000','#FFC000','#00B0F0','#92D050']


def calculateSignificantPercentages(answers):
    """
    Calculate the percentage of each significant answer.

    Parameters
    ----------
    subListPercentages : List
        Sub list of the answers list, it contains only significant answers.
    nbStudentsTookSurvey : int
        Total number of students that took the survey.

    Returns
    -------
    out : List
        Significant answers in the form of percentages.
    """
    # get the sublist of answers
    signAnswers = answers[:4]
    # get the number of students that took the survey
    StudentsTookSurvey = sum(signAnswers)
    if StudentsTookSurvey == 0:
        return [0] * 6
    significantPercentages = [round(subListPercentage / StudentsTookSurvey * 100) for subListPercentage in signAnswers]
    
    # complete with zeros to get the same length as the normalized list of percentages
    significantPercentages += [0,0]

    significantPercentages = [round(percent,2) for percent in significantPercentages]

    return significantPercentages


def createFigure(signAnswers):
    """
    Create the graph of the percentage of each answer.

    Parameters
    ----------
    signAnswers : List
        List of significant answers.

    Returns
    -------
    out : BytesIO
        The graph image.
    """
    # Create the x coordinates of the left sides of the bars
    lefts = [0] + [sum(signAnswers[:i]) for i in range(1, len(signAnswers))]
    
    # Generate the figure
    plt.figure(figsize=(30, 2))
    plt.barh(0, signAnswers, left=lefts, align='center', color=COLORS)
    plt.gca().axis('off')
    plt.margins(0)

    # Display the percentages only if they are not null
    font = {'family': 'serif', 'color':  'black', 'weight': 'normal', 'size': 40}
    for i, percent in enumerate(signAnswers):
        if percent != 0:
            plt.text(lefts[i] + signAnswers[i] / 2, 0, f"{percent}%", va='center', ha='center', fontdict=font)
   
    # Make an image of the figure
    image = BytesIO()
    plt.savefig(image, format='jpg', bbox_inches='tight', pad_inches=0)
    plt.close()
    return image


def getGraphs(questions):
    """
    Gets the graphs images for all the questions.

    Parameters
    ----------
    questions : dict
        Dictionary containing the questions with the percentage of each answer.

    Returns
    -------
    out : dict
        A dictionnary in which keys are the questions codes and values are the 
        graphs images.
    """
    # Configure matplotlib to speed up figure generation
    matplotlib.use('Agg')

    # Generates the images
    images = {}
    for key, question in questions.items():

        # Get the answers
        answers = question['answer']

        subListPercentages = calculateSignificantPercentages(answers)

        # Create the figure
        image = createFigure(subListPercentages)

        # Add the path to the dictionnary of paths
        images[key] = image
    
    return images