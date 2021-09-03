pipeline {
    agent any
    tools {
        maven 'mvn3.6.3'
        jdk 'jdk8'
    }

    stages {
        stage('init') {
            steps {
                sh '''
                echo "PATH=${PATH}"
                echo "M2_HOME=${M2_HOME}"
                '''
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        unsuccessful {
            sh '''
            echo "Running them tests again..."
            echo "Although I don' quite get how, I try to!"
            '''
        }
    }
}