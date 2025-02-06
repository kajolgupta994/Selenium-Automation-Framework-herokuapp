pipeline {
    agent any

    environment {
        TESTNG_XML = 'testng.xml'
        AUTOIT_PATH = 'C:\\Program Files (x86)\\AutoIt3\\AutoIt3.exe'
        AUTOIT_SCRIPT = "${WORKSPACE}\\src\\main\\java\\resources\\AutoIT\\HandleDigestAuthentication.exe"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/kajolgupta994/Selenium-Automation-Framework-herokuapp.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run AutoIt Script') {
            steps {
                bat "\"${env.AUTOIT_PATH}\" \"${env.AUTOIT_SCRIPT}\""
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test -Dsurefire.suiteXmlFiles=${env.TESTNG_XML}"
            }
        }

        stage('Publish TestNG Reports') {
            steps {
                publishTestNG testResultsPattern: '**/target/surefire-reports/testng-results.xml', escapeTestDescp: true, escapeExceptionMsg: true
            }
        }
    }
}
