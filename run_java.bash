#!/bin/bash


# Set the classpath including log4j jars
classpath=".:./log4j-core-2.20.0.jar:./log4j-api-2.20.0.jar"

# Compile the ChildProcess.java file
javac -cp "$classpath" ChildProcess.java

# Compile the SubChildProcess.java file
javac -cp "$classpath" SubChildProcess.java

# Run the ChildProcess class with log4j configuration
java -cp "$classpath" -Dlog4j.configurationFile=log4j2.xml ChildProcess &

# Run the SubChildProcess class with log4j configuration
java -cp "$classpath" -Dlog4j.configurationFile=log4j2.xml SubChildProcess

