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
                sh 'cd docker && ./build.sh'
            }
        }
        stage('Deploy') {
            agent { docker 'somedockercompany/rest-app-deploy:latest' }
            steps {
                sh '''
                docker-machine env rest-app-vm --shell bash
                eval $(docker-machine env rest-app-vm --shell bash)
                docker stop $(docker ps -q) || true &&
                docker pull somedockercompany/simple-rest-app:latest
                docker run -p 8090:8080 -dit somedockercompany/simple-rest-app:latest
                '''
            }
        }
    }
}
