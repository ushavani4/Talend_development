# Aero Batch
A generic configuration driven Edifact parser (tied to Amadeus file format). The project uses Spring batch.
The input file is iterated and a chunk is made from UNH to UNT (which is the start and end of FDR message). The chunk is mapped to corresponding java classes under aero.ws/aero-batch/src/main/java/com/aero/ic/fdr/message/* and written to Json file at the moment.
<p/>The entire mapping and orchestration is done through FDR mapping configuration fdr-edi-config.xml. This file describes the structure/branch of incoming edifact file (which is IFLIRR now) and also mentions segments/segment groups, composite elements and data elements in each segment.

# Development Environment
* Open Eclipse/IntelliJ IDE
* Import Maven project - select pom.xml and Import. This should add all necessary dependencies
* Run class com.aero.ic.AeroBatchMain after changing the properties described below

# Application Properties
Application configuration can be made through aero-batch/src/main/resources/application.yml file. Change the below properties according to your environment, <br/>

* dropZone - Edifact file location, change this to the folder where you have edifact file

* fileNamePattern - Edifact file extension pattern. such <code>*.DATA, *.txt</code> etc

* outZone - Where to write the converted file. At the moment the application generates only a Json output.

* fdrMappingFile - IFLIRR mapping configuration xml file location. By default this is available as 'aero-batch/src/main/resources/fdr-edi-config.xml'

# Running outside Development Environment

* Build project - goto the project directory 'aero-batch/'
* Run mvn compile
* java -jar target/aero-batch-1.0-SNAPSHOT.jar
<br/>
Note: If you have to change the properties then specify property as a JVM parameter
-Dproperty=value <br/>
-Daero.batch.dropZone=C:/users/nairr5/edifact-files/
