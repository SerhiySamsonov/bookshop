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
                echo "PATH=${PATH}"
                echo "M2_HOME=${M2_HOME}"
                '''
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('test') {
            try {
                sh 'mvn test'
            } catch (ex) {
                tests_failed = true
            }
        }
        stage('optional retest') {
            when {
                tests_failed == true
            }
            steps {
                sh 'mvn test'
            }

            when {
                tests_failed == false
            }
            steps {
                echo 'Nothing to do here...'
            }
        }
    }
}