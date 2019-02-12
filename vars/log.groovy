
def checkLog(String stage) {
    step([$class: 'LogParserPublisher', failBuildOnError: true, parsingRulesPath: '/home/ubuntu/log-parser-rule', useProjectRule: false])
    if ('FAILURE' == currentBuild.result) {
        notifySlackFailureStage(stage)
        throw error("")
    }
}

def info(message) {
    echo "INFO: ${message}"
}


def notifySlackStartStage(String stage) {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${stage} `STARTED`"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#D4DADF',
        token: env.SLACK_TOKEN
}

def notifySlackSuccessStage(String stage) {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${stage} `SUCCESS`"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#BDFFC3',
        token: env.SLACK_TOKEN
}

def notifySlackFailureStage(String stage) {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${stage} `FAILED`"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#FF9FA1',
        token: env.SLACK_TOKEN
}

def notifySlackFailureBuild() {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` Pipeline executed `FAILED` ${env.BUILD_URL}"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#FF9FA1',
        token: env.SLACK_TOKEN
}

def notifySlackSuccessBuild() {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]* `${env.JOB_NAME}` Pipeline executed `SUCCESS` ${env.BUILD_URL}"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#BDFFC3',
        token: env.SLACK_TOKEN
}

def notifySlackAbortedBuild() {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]* `${env.JOB_NAME}` Pipeline  `ABORTED` ${env.BUILD_URL}"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#FF9FA1',
        token: env.SLACK_TOKEN
}

