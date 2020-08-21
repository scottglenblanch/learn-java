#!/bin/bash

JAR_LOCATION=""
MAIN_CLASS_LOCATION=""
PORT=""

create_jar() {

  mvn install
}

open_browser() {
  open "http://127.0.0.1:${PORT}"
}

run_jar() {
  echo "

  Running Jar file. APP will run on Port ${PORT}

  "

  java -jar -Dserver.port="${PORT}" "${JAR_LOCATION}"
}

set_vars_from_argument_defaults() {
  PORT="8080"
}

set_vars_from_arguments() {
  set_vars_from_argument_defaults

  source /dev/stdin <<< \
    "$(curl https://raw.githubusercontent.com/scottglenblanch/bash-argument-parser/main/src/arg-parser.sh)" $@
}

set_vars() {
  JAR_LOCATION="./target/lesson13-1.0.0-SNAPSHOT.jar"
  MAIN_CLASS_LOCATION="com.scott.learnjava.Lesson12Application"

  set_vars_from_arguments "$@"

}

set_vars "$@"
create_jar
open_browser
run_jar
