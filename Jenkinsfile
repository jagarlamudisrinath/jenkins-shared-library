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

                    // Verify the file and its path
                    sh "ls -l repo"
                    sh "pwd"
                    
                   // Parse the YAML file and convert to JSON
                    def database_name = sh(script: "yq e \'.database\' ${yamlFilePath}", returnStdout: true).trim()
                    // Parse the YAML file and convert to JSON
                    def schedule = sh(script: "yq e \'.schdeule\' ${yamlFilePath}", returnStdout: true).trim()
                    echo "database name ${database_name}, ${schedule}"
                    def folder="myfolder"
                    def jobname = "myfolder"
                    createJob(schedule, folder, jobname)
                }
            }
        }
    }
}