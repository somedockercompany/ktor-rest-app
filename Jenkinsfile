pipeline {
    agent any
    stages {
        stage('Maven build') {
            agent { docker 'maven:3-alpine' }
            steps {
                echo 'Hello, Maven'
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            agent any
            steps {
                sh './docker/build.sh'
            }
        }
    }
}