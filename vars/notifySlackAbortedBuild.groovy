def call() {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]* `${env.JOB_NAME}` Pipeline  `ABORTED` ${env.BUILD_URL}"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#FF9FA1',
        token: env.SLACK_TOKEN
}
