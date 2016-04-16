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

2. Navigate to WebApp/util. If you have not already created a database, open
   MySQL and execute the following command:

```
CREATE DATABASE CodingCareers;
exit
```

3. Execute the command:
```
./constructDB dbname username full_path_to_util_dir
```
e.g.
```
./constructDB CodingCareers root /home/user/4448/CodingCareers/WebApp/util
```
Do not include a / at the end of the util path. If the table in the database
contains null entries for task instructinos and test code, follow the steps in
constructDB to resolve permission errors.
