def call(String folder) {
    if (folder.contains('/')) {
        // Split the folder path by '/'
        def parts = folder.split('/')
        // Join the parts with '/job/' in between
        return parts.collect { "job/${it}" }.join('/')
    } else {
        // If there's no '/', just return "job/folder"
        return "job/${folder}"
    }
}

