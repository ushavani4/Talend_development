**Aero Converter**

Converts from Amadeus Edifact format to normal Edifact format replacing 1C, 1F, 1D characters to \n, +, : characters

**Project Setup**
This is maven project, use Eclipse or IntelliJ Idea editor to import the project.

**Running Project**

Run EdifactParserApplication.java (main class) through editor

**Edifact file Drop location**

Drop the Amadeus edifact files at aero-converter/drop folder. The project will parse and convert the files

**Edifact Output Location**

The converted files will be dropped into aero-converter/out folder

**Building and Running in command line**

You may build a uber JAR from this project using Maven and run in command line

Build
1. open shell and cd to $project_dir/
2. mvn clean compile package

Run
3. Run with java as below

`java -Dedifact.parser.dropLocation=<drop-location> -Dedifact.parser.outputLocation=<output-location> -jar aero-converter-0.0.1-SNAPSHOT.jar`

for eg:
`java -Dedifact.parser.dropLocation=/Users/nair/workspace/sa.git.ws/aero-converter/drop/ -Dedifact.parser.outputLocation=./out/ -jar aero-converter-0.0.1-SNAPSHOT.jar`

where,
-Dedifact.parser.dropLocation - this is the location where you have original Amadeus edifact file(s)
-Dedifact.parser.outputLocation - this is output location where program is place the converted file(s)

The drop location can have one or more edifact file(s)

Note : Adjust the file paths accordingly in windows.