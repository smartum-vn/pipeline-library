def call(String stage) {
    step([$class: 'LogParserPublisher', failBuildOnError: true, parsingRulesPath: '/home/ubuntu/log-parser-rule', useProjectRule: false])
    if ('FAILURE' == currentBuild.result || 'ABORTED' == currentBuild.result) {
        notifySlackFailureStage(env.STAGE_NAME)
        throw error("")
    } else 
    {
        notifySlackSuccessStage(env.STAGE_NAME)
    }
}
def notifySlackFailureStage(String stage) {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${stage} `FAILED`"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#FF9FA1',
        token: env.SLACK_TOKEN
}

def notifySlackSuccessStage(String stage) {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${stage} `SUCCESS`"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#BDFFC3',
        token: env.SLACK_TOKEN
}
