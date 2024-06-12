@Library('your-shared-library') _  // If you're using a shared library for snakeyaml

pipeline {
    agent any
    stages {
         stage('Clean Workspace') {
            steps {
                script {
                    // Remove the repo directory if it exists
                    sh 'rm -rf repo'
                }
            }
        }
        stage('Clone Repo') {
            steps {
                script {
                    // Clone the repository
                    sh 'git clone https://github.com/jagarlamudisrinath/jenkins-shared-library.git repo'
                }
            }
        }
        stage('Read YAML') {
            steps {
                script {
                    // Path to your YAML file
                    def yamlFilePath = 'repo/test.yml'

                    def yaml = sh(script: "cat ${yamlFilePath}", returnStdout: true).trim()

                    def result = extractSchedule(yaml)
                    def database_name = result.database_name
                    def schedule = result.schedule
                    
                    echo "Database name: ${database_name}, Schedule: ${schedule}"
                }
            }
        }
    }
}
