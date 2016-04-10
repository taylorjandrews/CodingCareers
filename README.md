# CodingCareers
OOAD Project for Spring 2016

## Running
In order to run the website locally...

1. Download the gwt sdk (http://www.gwtproject.org/download.html). After you 
have downloaded it, unzip the file and place unzipped contents in WebApp. 
Make sure the directory that you have unzipped is named "gwt".

2. Navigate to the WebApp directory and type the following command.
'''
ant devmode
'''

3. A pop up should come up with the status of GWT app. Select the option to
launch in browser.

## Set up database
Follow the steps bellow in order to set up a database for use.

1. Make sure you have MySQL installed and working correctly.

2. Navigate to WebApp/util and open MySQL. If you have not already created
   a database, execute the following commands.

'''
CREATE DATABASE CodingCareers;
USE CodingCareers;
'''

3. Once you are using your desired database execute the following line.

'''
.\ constructDB.sql
'''
