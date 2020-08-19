#!/bin/bash

JAR_LOCATION=""
MAIN_CLASS_LOCATION=""

create_jar() {
  echo "

  Creating Jar file

  "
  mvn install
}

run_jar() {
  echo "

  Running Jar file

  "

  java -cp "${JAR_LOCATION}" "${MAIN_CLASS_LOCATION}"
}

set_vars() {
  JAR_LOCATION="./target/lesson6-1.0-SNAPSHOT.jar"
  MAIN_CLASS_LOCATION="com.scott.learnjava.App"
}

set_vars
create_jar
run_jar
