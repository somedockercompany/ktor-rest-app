pipeline {
    agent any
    stages {
    /*
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
                sh 'cd docker && ./build.sh'
            }
        }
        */
        stage('Deploy') {
            agent { docker 'somedockercompany/rest-app-deploy:latest' }
            steps {
            sh 'docker-machine ls'
                sh '''docker-machine ssh rest-app-vm
                 docker stop $(docker ps -q) || true
                 docker run -p 8090:8080 -dit somedockercompany/simple-rest-app:latest
                '''
            }
        }
    }
}