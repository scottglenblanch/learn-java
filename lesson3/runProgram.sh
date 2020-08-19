#!/bin/bash

SCRIPT_DIR=""
CLASSES_DIR=""
SRC_DIR=""
MAIN_CLASS_NAME=""

set_environment() {
  mkdir -p "${CLASSES_DIR}"
}

set_variables() {
  SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
  CLASSES_DIR="${SCRIPT_DIR}/classes"
	SRC_DIR="${SCRIPT_DIR}/src"
	MAIN_CLASS_NAME="App"
}

compile_source_code_to_java_bytecode() {
  javac -d "${CLASSES_DIR}" "${SRC_DIR}/"*.java
}

execute_program() {
	java -cp "${CLASSES_DIR}": ${MAIN_CLASS_NAME} "$@"
}

set_variables
set_environment
compile_source_code_to_java_bytecode
execute_program "$@"



