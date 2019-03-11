#!/bin/bash

cp ../target/*-jar-with-dependencies.jar app.jar
tar -cf app.tar.gz app.jar

docker build -t somedockercompany/simple-rest-app:latest .

docker push somedockercompany/simple-rest-app:latest

rm -rf app.jar app.tar.gz