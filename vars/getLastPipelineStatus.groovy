def call(String jobName) {
    def result = 'SUCCESS'
    def pipeline = Jenkins.instance.getItemByFullName(jobName, Job.class)
    def lastBuild = pipeline.getLastBuild()
    if (lastBuild == null || (lastBuild != null && lastBuild.getResult().toString() != 'SUCCESS')) {
        result = 'FAILURE'
    }
    return result
}
