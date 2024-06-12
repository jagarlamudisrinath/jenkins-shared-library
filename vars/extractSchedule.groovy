def call(String yamlString) {
    echo "Hello, ${yamlString}"
    // Parse the YAML file and convert to JSON
    def database_name = sh(script: "echo ${yamlString} | yq e \'.database\'", returnStdout: true).trim()
    // Parse the YAML file and convert to JSON
    def schedule = sh(script: "echo ${yamlString} | yq e \'.schdeule\'", returnStdout: true).trim()
    echo "database name ${database_name}, ${schedule}"
}