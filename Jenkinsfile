pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Erayakg/JenkinsDockerDemo'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("demo-app:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    docker.image("demo-app:${env.BUILD_NUMBER}").run("-d -p 8989:8989 --name demo-container")
                }
            }
        }
    }

    post {
        always {
            script {
                try {
                    docker.stop("demo-container")
                    docker.removeContainer("demo-container")
                    docker.image("demo-app:${env.BUILD_NUMBER}").remove()
                } catch (Exception e) {
                    echo "Hata oluştu: ${e.message}"
                    currentBuild.result = 'FAILURE'
                }
            }
        }
    }
}
