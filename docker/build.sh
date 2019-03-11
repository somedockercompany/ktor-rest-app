#!/bin/bash

#Copy the jar to this folder
cp ../target/*-jar-with-dependencies.jar app.jar

#Create tarball archive
tar -cf app.tar.gz app.jar

#Build the docker image
docker build -t somedockercompany/simple-rest-app:latest .

#Login to Docker Hub
docker login

#Push the image to Docker Hub
docker push somedockercompany/simple-rest-app:latest

#Delete the tarball file
rm -rf app.jar app.tar.gz