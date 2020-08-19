#!/bin/bash

SCRIPT_DIR=""
CLASSES_DIR=""
SRC_DIR=""

set_environment() {
  mkdir -p "${CLASSES_DIR}"
}

set_variables() {
  SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
  CLASSES_DIR="${SCRIPT_DIR}/classes"
	SRC_DIR="${SCRIPT_DIR}/src"
}

compile_source_code_to_java_bytecode() {
  javac -d "${CLASSES_DIR}" "${SRC_DIR}/HelloWorld.java"
}

execute_program() {
	java -cp "${CLASSES_DIR}": HelloWorld
}

set_variables
set_environment
compile_source_code_to_java_bytecode
execute_program

