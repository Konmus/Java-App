pipeline {
    agent any

    enviroment {
        ORG_NAME = 'Demo'
        APP_NAME = 'demo-java'
        APP_VERSION = '0.0.1-SNAPSHOT'
        APP_LISTENING_PORT = '8080'
    }
    stages{
        stage('Prepare Environment'){
            steps{
                script{
                    qualityGates = readYaml file: 'quality-gate.yaml'
                }
            }
        }
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
                sh 'gradle test'
            }
        }
        stage('Build'){
            steps{
                sh './gradlew clean build'
            }
        }
    }
}