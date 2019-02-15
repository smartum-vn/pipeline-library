def call(String[] pipelines) {
    def stagingBuildStatus = 'SUCCESS'
    Jenkins.instance.getAllItems(Job.class).each {it->
        if (projectList.contains(it.name)) {
            def lastBuild = it.getLastBuild()
            if (lastBuild == null || (lastBuild != null && lastBuild.getResult().toString() != 'SUCCESS')) {
                stagingBuildStatus = 'FAILURE'
            }
        }
    }
    return stagingBuildStatus
}
