pipeline {
    agent any

    tools {
        maven 'Maven'  // Use the Maven installation configured in Jenkins
    }

    environment {
        TESTNG_XML = 'testng.xml'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/kajolgupta994/Selenium-Automation-Framework-herokuapp'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test -Dsurefire.suiteXmlFiles=${TESTNG_XML}'
            }
        }

        stage('Publish Test Reports') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
