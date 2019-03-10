pipeline {
    agent none
    stages {
        stage('Example Build') {
            agent { docker 'maven:3-alpine' }
            steps {
                echo 'Hello, Maven'
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            agent none
            steps {
                sh 'docker login && docker./build.sh'
            }
        }
    }
}