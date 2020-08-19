#!/bin/bash

JAR_LOCATION=""
MAIN_CLASS_LOCATION=""
LANGUAGE_ARG=""

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

  java -cp "${JAR_LOCATION}" "${MAIN_CLASS_LOCATION}" "${LANGUAGE_ARG}"
}

set_vars() {
  JAR_LOCATION="./target/lesson8-1.0-SNAPSHOT.jar"
  MAIN_CLASS_LOCATION="com.scott.learnjava.App"
  LANGUAGE_ARG="${1}"
}

set_vars "$@"
create_jar
run_jar
