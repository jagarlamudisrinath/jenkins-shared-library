def call(String directory) {
    // Execute the Bash command to list YAML files and capture the output
    def yamlFiles = sh(script: "find ${directory} -type f -name '*.yaml' -o -name '*.yml'", returnStdout: true).trim()
    
    // Split the output into a list of file names
    def yamlFileList = yamlFiles.split('\n')

    // Return the list of YAML file names
    return yamlFileList
}
