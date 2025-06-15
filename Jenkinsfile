pipeline {
    agent {
        label 'unix || win' // Use either Unix or Windows agent
    }
    environment {
        // Define environment variables (can be loaded from Jenkins credentials)
        EXPRESS_PORT = credentials('EXPRESS_PORT')
        SOCKET_PORT = credentials('SOCKET_PORT')
        MONGO_ATLAS_URL = credentials('MONGO_URL')
        TOKEN_STRING = credentials('TOKEN_STRING')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm    
            }
        }
        stage('Add Env File') {
            steps {
                script {
                    if (isUnix()) {
                        sh '''
                        cat <<EOF > .env
                        EXPRESS_PORT=${EXPRESS_PORT}
                        TOKEN_STRING=${TOKEN_STRING}
                        SOCKET_PORT=${SOCKET_PORT}
                        MONGO_ATLAS_URL=${MONGO_URL}
                        EOF
                        '''
                    } else {
                        bat '''
                        echo EXPRESS_PORT=%EXPRESS_PORT% > .env
                        echo TOKEN_STRING=%TOKEN_STRING% >> .env
                        echo SOCKET_PORT=%SOCKET_PORT% >> .env
                        echo MONGO_ATLAS_URL=%MONGO_URL% >> .env
                        '''
                    }
                }
            }
        }
        stage('Upload Server') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'npm ci'
                        sh 'nohup npm start &'
                    } else {
                        bat 'npm ci'
                     
                    }
                }
            }
        }
    }
    post {
        // Actions to perform after the pipeline completes
        success {
            echo 'Pipeline succeeded! 🎉'
            // Notify the team (e.g., via email, Slack, etc.)
        }
        failure {
            echo 'Pipeline failed! 😢'
            // Notify the team (e.g., via email, Slack, etc.)
        }
    }
}