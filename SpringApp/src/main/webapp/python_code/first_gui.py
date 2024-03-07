# first_gui.py

import PySimpleGUI as sg
import os.path
from report_generation import generateReports

#theme
font = ('Titillium Web', 11)
sg.set_options(font=font)
sg.theme('Light Gray 1')
ttk_style = 'clam'


# First the window layout in 2 columns

#Selection of the .json folder
file_list_column = [
    [sg.Text("Please enter the path where your jsons files are located:")],
    [
        sg.Text(".json Folder"),
        sg.In(size=(50, 1), enable_events=True, key="-FOLDER-"),
        sg.FolderBrowse(),
    ],
    [sg.Text("These are the files that will be dealt:")],
    [
        sg.Listbox(
            values=[], enable_events=True, size=(60, 23), key="-FILE LIST-"
        )
    ],
]

# Selection of parameters and generation of the synthesis
rtf_saving_column = [
    [sg.Text("Choose your saving path:")],
    [sg.In(size=(50, 1), enable_events=True, key="-SAVING-BROWSER-"), sg.FolderBrowse(),],
    [sg.Text("The synthesis will be generated in this browser when clicking on save button:")],
    [sg.Text(size=(80, 1), key="-TOUT-")],
    [sg.Text("Minimum percentage of positive evaluation on a question to be considerate 'positive'.")],
    [sg.Slider((0,100), default_value=67, resolution=1,orientation= 'horizontal', key= "-GOOD-EVAL-SLIDER-", size= (50,12))],
    [sg.Text("Maximum percentage of positive evaluation on a question to be considerate 'negative'.")],
    [sg.Slider((0,100), default_value=50, resolution=1,orientation= 'horizontal', key= "-BAD-EVAL-SLIDER-", size= (50,12))],
    [sg.Text("Percentage of significative response among the registered student.")],
    [sg.Slider((0,100), default_value=40, resolution=1,orientation= 'horizontal', key= "-SIGNIFICATIVE-RESP-STUDENT-", size= (50,12))],
    [sg.Text("")],
    [sg.Checkbox(text= "Are the .json already normalized ?", default= False, key= "-NORMALIZED-CHECKBOX-")],
    [sg.Text("")],
    [sg.Button("Save", key= '-SAVE-')],
    [sg.Text(size=(80, 1), key="-TOUTSAVE-")],
]

#Centrale nantes image
centrale_image_column = [
    [sg.Image(filename="design/centrale_logo.png", size= (300,150))],
]


# Combination of the columns
layout = [
    [
        sg.Column(file_list_column),
        sg.VSeperator(),
        sg.Column(rtf_saving_column, size = (570,600)),
        sg.VSeperator(),
        sg.Column(centrale_image_column, size = (280,600)),
    ]
]

# Creation of the window using the layout created before
window = sg.Window("Limesurvey JSON to docx synthesis generator", layout, ttk_theme=ttk_style)

# Management of the events while the script is running
while True:
    event, values = window.read()
    if event == "Exit" or event == sg.WIN_CLOSED:
        break

    # Folder name was filled in, make a list of files in the folder
    if event == "-FOLDER-":
        folder = values["-FOLDER-"]
        file_list = []
        try:
            # Get list of files in folder
            file_list = os.listdir(folder)
        except:
            file_list = []

        fnames = [
            f
            for f in file_list
            if os.path.isfile(os.path.join(folder, f))
            and f.lower().endswith((".json"))
        ]
        window["-FILE LIST-"].update(fnames)
    elif event == "-FILE LIST-":  # A file was chosen from the listbox
        try:
            pass
        except:
            pass
    elif event == "-SAVING-BROWSER-": #choose the saving browser
        try:
            if (values["-SAVING-BROWSER-"] != ""):
                savingFilename = values["-SAVING-BROWSER-"]
                window["-TOUT-"].update(savingFilename)
        except:
            pass
    elif event == "-SAVE-": #Some .docx files are generated
        try:
            #Indication
            window["-TOUTSAVE-"].update("Synthesis files are saved.")
            
            #Variables for Pierre's functions
            
            #Path to the folder with the jsons
            jsonFolderPath = values["-FOLDER-"]
            print('jsonFolderPath : ')
            print(jsonFolderPath)
            #Folder where to save the synthesis
            outputFolder = values["-SAVING-BROWSER-"]
            print('folderPath : ')
            print(outputFolder)
            #Slider for good evalutation
            goodSliderValue = values["-GOOD-EVAL-SLIDER-"]
            print('goodSliderValue : ')
            print(goodSliderValue)
            #Slider for bad evalutation
            badSliderValue = values["-BAD-EVAL-SLIDER-"]
            print('badSliderValue : ')
            print(badSliderValue)
            #Slider for significance
            significanceSliderValue = values["-SIGNIFICATIVE-RESP-STUDENT-"]
            print('significanceSliderValue : ')
            print(significanceSliderValue)
            #Chexkbox for normalization
            isNormalizedValue = values["-NORMALIZED-CHECKBOX-"]
            print('isNormalizedValue : ')
            print(isNormalizedValue)

            generateReports(jsonFolderPath, outputFolder, significanceSliderValue, goodSliderValue, badSliderValue, isNormalizedValue)
        except Exception as e :
            pass
            print('The error is the following : ')
            print(e)

window.close()
