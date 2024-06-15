def call(String yamlFilePath) {
    def database_name = getFileNameWithoutExtension(yamlFilePath)
    def yaml = sh(script: "cat ${yamlFilePath}", returnStdout: true).trim()
    def schedule = sh(script: "echo \"${yamlString}\" | yq e '.schdeule' -", returnStdout: true).trim()


    echo "Database name: ${database_name}, Schedule: ${schedule}"
    return [database_name: database_name, schedule: schedule]
}


def getFileNameWithoutExtension(String filePath) {
    if (filePath == null || filePath.isEmpty()) {
        return filePath
    }
    def fileName = new File(filePath).name
    if (fileName.endsWith(".yml")) {
        return fileName[0..-5] // Remove the last 4 characters (".yml")
    } else if (fileName.endsWith(".yaml")) {
        return fileName[0..-6] // Remove the last 5 characters (".yaml")
    } else {
        return fileName // Return the original file name if it doesn't end with ".yml" or ".yaml"
    }
}

