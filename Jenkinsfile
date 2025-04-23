pipeline {
    agent any

    environment {
        IMAGE_NAME = 'luonghuynhnam/urlshortener:latest'
        CONTAINER_NAME = 'urlshortener'
        PORT = '9001'
    }

    stages {
        stage('Pull latest image from DockerHub') {
            steps {
                // Pull image từ DockerHub
                sh 'docker pull $IMAGE_NAME'
            }
        }

        stage('Stop and remove old container') {
            steps {
                // Dừng và xóa container cũ nếu có
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                '''
            }
        }

        stage('Run new container') {
            steps {
                // Chạy container mới từ image đã pull
                sh '''
                docker run -d \
                    --name $CONTAINER_NAME \
                    -p $PORT:$PORT \
                    $IMAGE_NAME
                '''
            }
        }
    }
}
