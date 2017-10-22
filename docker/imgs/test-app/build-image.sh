#!/usr/bin/env bash

cd "$(dirname "$0")"

mvn clean compile -f ../../../pom.xml

cp ../../../target/jpa-1-1.0-SNAPSHOT-jar-with-dependencies.jar test-app.jar

docker build -t test-app .

rm test-app.jar