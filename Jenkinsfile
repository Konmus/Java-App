pipeline {
    agent any

    environment {
        ORG_NAME = 'konmus'
        APP_NAME = 'konmus'
        APP_VERSION = '0.1'
        APP_LISTENING_PORT = '80'
        remoteExec= 
        """
            sudo java -jar ~/konmus.war >> /dev/null
        """
        /// >> /dev/null without stdout 
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
                    sh 'scp ./build/libs/*.war vagrant@172.16.1.51:~/$APP_NAME.war'
                    sh 'ssh vagrant@172.16.1.51 $remoteExec '
                }
            }
        }
    }
}