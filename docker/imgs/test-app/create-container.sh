#!/usr/bin/env bash

cd "$(dirname "$0")"

docker run -d --name test-app test-app