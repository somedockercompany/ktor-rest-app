pipeline {
    agent any
    stages {
        stage('Maven build') {
            agent { docker 'maven:3-alpine' }
            steps {
                echo 'Hello, Maven'
                sh 'mvn clean install'
                stash name: "jar-stash", includes: "target/*-jar-with-dependencies.jar"

            }
        }
        stage('Build docker image') {
            agent any
            steps {
                unstash "jar-stash"
                sh 'ls'
                sh 'ls target/'
                sh './docker/build.sh'
            }
        }
    }
}