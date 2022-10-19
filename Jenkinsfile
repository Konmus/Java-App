pipeline {
    agent any

    environment {
        ORG_NAME = 'Demo'
        APP_NAME = 'demo-java'
        APP_VERSION = '0.1'
        APP_LISTENING_PORT = '8080'
    }
    stages{
        stage('Git Checkout'){
            steps{
                git branch: 'master', url: 'https://github.com/Konmus/Java-App.git'
            }
        }
        stage('Build'){
            steps{
                sh './gradlew clean build'
            }
        }
        stage('Unit Test'){
            steps{
                sh './gradlew test'
            }
        }
        stage('Deploy to tomcat'){
            steps{
                sshagent(['tomcat']){
                    sh 'scp ./build/libs/*.war vagrant@172.16.1.51:~/apache-tomcat-10.0.27/webapps/webapp.war'
                }
            }
        }
    }
}