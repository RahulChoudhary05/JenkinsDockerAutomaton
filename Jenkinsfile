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
                // Navigate to the project directory and execute gradle clean build
                dir('JenkinsDockerAutomaton') {
                    bat 'gradlew clean build'
                }
            }
        }
        stage('Compile and Run Java Program') {
            steps {
                // Navigate to the Java source directory
                dir('lib/src/main/java/_Gradle_Project') {
                    // Compile the Java program
                    bat 'javac testsell.java'
                    
                    // Run the compiled Java program
                    bat 'java testsell'
                }
            }
        }
    }
}
