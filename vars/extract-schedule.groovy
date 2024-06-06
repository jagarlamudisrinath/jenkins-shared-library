def call(String name = "World") {
    // Parse the YAML file and convert to JSON
    def database_name = sh(script: "yq e \'.database\' ${yamlFilePath}", returnStdout: true).trim()
    // Parse the YAML file and convert to JSON
    def schedule = sh(script: "yq e \'.schdeule\' ${yamlFilePath}", returnStdout: true).trim()
    echo "database name ${database_name}, ${schedule}"
}