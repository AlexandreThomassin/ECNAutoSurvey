# ECNAutoSurvey

Student project - Development of a management tool for the entire teaching evaluation system by students

## Description



## Installation
To install this project, use the following commands in your terminal:
- Clone with SSH:
  git clone git@github.com:AlexandreThomassin/ECNAutoSurvey.git
- Clone with HTTPS:
  git clone https://github.com/AlexandreThomassin/ECNAutoSurvey
Then, navigate to the cloned repository directory:
```
cd ECNAutoSurvey
```

### Requirements
- Java JDk $\ge$ 11, preferably 17
- Web server : There is a Tomcat 9 server given in this repository
- PostgreSQL : version 15 recommended
- IDE : This guide is written for NetBeans but you're free to use the one you want

#### Register a Tomcat server in netbeans (taken from Jean-Yves Martin slides from PrWeb classes) :
Open the project you just cloned with NetBeans  
In the left panel select "Services", right click on "Server" and select "Add Server"

Select "Apache Tomcat or TomEE" as a server type  
Give a name to the server in the “Name” area.  
Click on “Next”.  

Give tomcat directory location : It's the "Tomcat server" folder in the repository  
Give the username and the password of an admin user :
```
- Username : admin
- Password : admin  

(Yeah i know, security at its highest level ...)
```

Validate to create server by clicking on “Finish”.

#### Configure PostgreSQL for the project :
You should already have PostgreSQL local server configured.

Create a new user:  
```
On PgAdmin right click on your server, select "Create" > "Login/Group role" and set :
- Name: pgrou
- Privileges : at least "Can login?"  
```

Next, create a new Database, call it "SpringApp" and set the user "pgrou" to owner.  
Open Query tool. Import "CreateDatabase.sql" and run it.

<span style="color:red; font-weight:bold"> WARNING :</span> These names are mandatory to run the project, if you want to change them you'll have to modify all the Spring configuration files.

#### Run the project
At this point you should be able to run the project on NetBeans.  
You'll have to give the Username and password of the Tomcat server each time you open NetBeans (Those are given above)  
Go to [127.0.0.1:8080/SpringApp](127.0.0.1:8080/SpringApp) to see the Application




## Architecture
TODO a

## Current features
TODO

## Usage 
TODO

## Authors and acknowledgment
This project was directed by members of the administration of Centrale Nantes, and realized by six Informatique pour les Systèmes d'Information students in Centrale Nantes.

We thank our professors for their help in setting up the Spring project.

## Project status
