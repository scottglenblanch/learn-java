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

copy_frontend_build_to_resources_directory() {
  cp -R "${FRONT_END_APP_BUILD_DIR}" "${FRONT_END_APP_RESOURCES_BUILD_DIR}"
}

delete_frontend_build_in_frontend_app_dir() {
  rm -rf "${FRONT_END_APP_BUILD_DIR}"
}

delete_frontend_build_in_resources_dir() {
  rm -rf "${FRONT_END_APP_RESOURCES_BUILD_DIR}"
}

set_vars
delete_frontend_build_in_frontend_app_dir
delete_frontend_build_in_resources_dir
