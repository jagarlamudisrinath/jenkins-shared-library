def call(String yamlString) {
    echo "Called function"

    // Parse the YAML string and extract the database name and schedule
    def database_name = sh(script: "echo \"${yamlString}\" | yq e '.database' -", returnStdout: true).trim()
    echo "Extracted database name"

    def schedule = sh(script: "echo \"${yamlString}\" | yq e '.schdeule' -", returnStdout: true).trim()
    echo "Extracted schedule"

    echo "Database name: ${database_name}, Schedule: ${schedule}"
    return [database_name: database_name, schedule: schedule]
}
