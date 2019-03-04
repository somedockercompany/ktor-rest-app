FROM openjdk:8u191-jdk-alpine3.9

COPY app.tar.gz app.tar.gz

RUN tar -xf app.tar.gz

ENTRYPOINT java -jar app.jar