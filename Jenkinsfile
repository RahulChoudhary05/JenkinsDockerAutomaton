pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                git 'https://github.com/RahulChoudhary05/JenkinsDockerAutomaton.git'
            }
        }
        stage('Build') {
            steps {
                // Navigate to the project directory and execute gradle tasks
                dir('JenkinsDockerAutomaton') {
                    bat 'gradlew clean build'
                }
            }
        }
    }
}
