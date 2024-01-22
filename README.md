# MPTranslator

Mathematical Problem Translator  - Student Project: AMPL to Minibex Language Converter

## Description
This project is dedicated to developing a tool that converts models from AMPL (A Mathematical Programming Language) to the Minibex language. This tool will enable users to effortlessly switch between these two languages while maintaining the readability and functionality of the code. It will easily be extendable to other languages, but only the translation from AMPL to Minibex is currently computed.

## Installation
To install this project, use the following commands in your terminal:
- Clone with SSH:
  git clone git@gitlab.univ-nantes.fr:chenouard-r/mptranslator.git
- Clone with HTTPS:
  git clone https://gitlab.univ-nantes.fr/chenouard-r/mptranslator.git
Then, navigate to the cloned repository directory:
cd mptranslator

## Architecture
Aside from this README.md file, the mptranslator repository contains the folders:

- Documents: set of folders and documents used during the project, like a bibliography, meeting reports and other research documents.

- Models: test files in AMPL and Minibex, manually translated (i.e. alkyl.mod for AMPL file and alkyl.mbx for Minibex translation). Some files were slightly modified to get a better translation with mptranslator (alkyl_test.mod and haverly_test.mod).

- Project deliverables: set of different deliverables like the Cahier des Charges (Specifications) or various reports 

- Source code : main folder for the Python codes. Composed of Amplpy_parser, Lark_parser, Other_parsers and Pyparsing_parser folders with test codes to try to create a parser for AMPL. The mptranslator folder contains the main code, using a Lark parser. Inside of the mptranslator folder in Source Code, you will find : 
  - an ampl.lark file which defines a grammar for AMPL to create the Lark parser with. ampl1.lark and ampl2.lark are older versions of the grammar, with an increasing order of version.
  - the class_model.py file, which creates a Model class using generic elements found in most languages like AMPL and Minibex, such as variables, objective functions, constraints, etc.
  - a tree_to_model.py file that is used to transform the output of the Lark parser, a Tree, to the Model class from class_model.py. Older versions of it are named tree_to_model1 and tree_to_model2.
  - the mptranslator.py file which is the main file for this project. It can read an input file and translate it to another language. 
  - test_methods.py: file with some test methods to create objects of the classes in class_model.py
  - an Output_files folder to store the results of mptranslator.py

## Current features
This translator currently features a translation for one AMPL file to the equivalent in the Minibex language.

The grammar file for AMPL only defines simple notions, such as variable, parameter, objective, and constraint declarations. This grammar file cannot parse elements like sets, loops or N-ary operators (sum, etc). Some functions are not implemented, the grammar file does not support reading numbers in scientific notation.

The class model is also incomplete, as some classes are not fully used and translated yet, like the NOperator or Comment classes. 

The transformation from the tree to the model is not working for some complex expressions, like:
- parentheses: only left-side parentheses can be transformed (i.e. (expr)\*x and not x\*(expr)) and double parentheses or parentheses in exponentiation are not handled properly.
- negative numbers: the original parsed value for a number is a string, so when parsing a negative number we change the string to a float to apply the negative value.
- functions: most functions added into the grammar were not tested, and their arguments are quite restrictive, so sometimes they cannot be parsed (i.e. log(x/y)).
- comments: multi-lined or complex comments, such as using unusual symbols (i.e. "=" or "/") are not parsed correctly.

To ensure a good result of the translation, make sure to avoid the above-mentioned conditions.

## Usage 
To use the mptranslator, ensure the Python environment is installed, and all dependency libraries are installed as per requirements found in mptranslator.py, class_model.py and tree_to_model.py.

You have to edit mptranslator to add files to translate, by changing the test_file variable and the path it refers to. Some paths to the files in the Models folder are already computed to facilitate the tests. You can also modify the variable test to directly write a text to translate. The output is then stored in the Output_files folder, with the name output_idx.mbx.

Execute mptranslator.py to run the conversion from AMPL models to Minibex.

The output files are stored inside the Output_files folder in Source Code/mptranslator.

## Authors and acknowledgment
This project was directed by members of the OGRE team in Centrale Nantes, and realized by two Informatique pour les Systèmes d'Information students in Centrale Nantes.

## Project status
The project was developped from October to December 2023. 
The final report, which provides further details about the project, is available in the Project deliverables folder.

# Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.univ-nantes.fr/chenouard-r/mptranslator.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.univ-nantes.fr/chenouard-r/mptranslator/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***
