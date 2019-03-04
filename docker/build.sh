#!/bin/bash

cp ../target/*-jar-with-dependencies.jar app.jar
tar -cf app.tar.gz app.jar

docker build -t com2ghz/simple-rest-app .

rm -rf app.jar app.tar.gz