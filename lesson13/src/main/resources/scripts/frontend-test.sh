#!/bin/bash

FRONT_END_DIR=""
FRONT_END_APP_DIR=""
FRONT_END_APP_BUILD_DIR=""
FRONT_END_APP_RESOURCES_BUILD_DIR=""
RESOURCES_DIR=""
SCRIPT_DIR=""

set_vars() {
  SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
  FRONT_END_DIR="$(cd "${SCRIPT_DIR}"; cd ../../../frontend; pwd)"
  FRONT_END_APP_DIR="${FRONT_END_DIR}/hello-world"
  FRONT_END_APP_BUILD_DIR="${FRONT_END_APP_DIR}/build"
  RESOURCES_DIR="$(cd "${SCRIPT_DIR}"; cd ..; pwd)"
  FRONT_END_APP_RESOURCES_BUILD_DIR="${RESOURCES_DIR}/public"
}

run_frontend_tests() {
  cd "${FRONT_END_APP_DIR}"

  yarn test
}

set_vars
run_frontend_tests