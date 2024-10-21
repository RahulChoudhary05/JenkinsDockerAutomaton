pipeline {
    agent any
    environment {
        registry = "rahulchoudhary05" // Your Docker Hub username
        imageName = "jenkinsdockerautomation" // Your desired image name
        dockerImageTag = "latest"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/RahulChoudhary05/JenkinsDockerAutomaton.git'
            }
        }
        stage('Build') {
            steps {
                dir('JenkinsDockerAutomaton') {
                    bat 'gradlew clean build'
                }
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        def customImage = docker.build("${registry}/${imageName}:${dockerImageTag}", ".")
                        customImage.push()
                    }
                }
            }
        }
    }
}
