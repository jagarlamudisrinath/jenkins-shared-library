def createJobWithSchedule(schedule, folder, jobname) {
    def jobXml = """
    <project>
        <actions/>
        <description></description>
        <keepDependencies>false</keepDependencies>
        <properties>
            <hudson.model.ParametersDefinitionProperty>
                <parameterDefinitions>
                    <hudson.model.StringParameterDefinition>
                        <name>schedule</name>
                        <description>Schedule for the job</description>
                        <defaultValue>${schedule}</defaultValue>
                        <trim>false</trim>
                    </hudson.model.StringParameterDefinition>
                </parameterDefinitions>
            </hudson.model.ParametersDefinitionProperty>
        </properties>
        <scm class="hudson.scm.NullSCM"/>
        <assignedNode></assignedNode>
        <canRoam>true</canRoam>
        <disabled>false</disabled>
        <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
        <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
        <triggers>
            <hudson.triggers.TimerTrigger>
                <spec>${schedule}</spec>
            </hudson.triggers.TimerTrigger>
        </triggers>
        <concurrentBuild>false</concurrentBuild>
        <builders/>
        <publishers/>
        <buildWrappers/>
    </project>
    """

    // Create the job
    def jobFolderPath = "${folder}/${jobname}"
    def createJobCommand = """
    curl -X POST "http://localhost:8080/createItem?name=${jobFolderPath}" \\
        --user "admin:admin" \\
        --header "Content-Type: application/xml" \\
        --data-binary '${jobXml}'
    """
    sh createJobCommand
    echo "Job '${jobname}' created in folder '${folder}' with schedule '${schedule}'"
}
