def tests_failed = false

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
                touch /opt/some/stuff/initStage1.txt
                echo "init stage going on" > /opt/some/stuff/initStage1.txt
                echo "PATH=${PATH}"
                echo "M2_HOME=${M2_HOME}"
                '''
            }
        }
        stage('build') {
            steps {
                sh '''
                touch buildStage1.txt
                echo "build stage going on" > buildStage1.txt
                cat /opt/some/stuff/initStage1.txt
                '''
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('test') {
            steps {
                sh 'cat buildStage1.txt'
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        tests_failed = true
                        throw new Exception("Arbitrary test step failure")
                    }
                }
            }
        }
        stage('optional retest') {
            steps {
                script {
                    if (tests_failed) {
                        sh 'mvn test'
                    }
                }
            }

        }
    }
    post {
        always {
            sh 'cat /opt/some/stuff/initStage1.txt'
            sh 'cat buildStage1.txt'
        }
    }
}