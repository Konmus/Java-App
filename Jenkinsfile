pipeline {
    agent any
    
    stages{
        stage('Git Checkout'){
            steps{
                git Checkout
            }
        }
        stage('Build'){
            steps{
                sh 'gradle build'
            }
        }
    }
}