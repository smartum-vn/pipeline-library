def call() {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${env.STAGE_NAME} `SUCCESS`"
    slackSend baseUrl: env.SLACK_URL, channel: env.SLACK_CHANNEL, message: msg, color: '#BDFFC3',
        token: env.SLACK_TOKEN
}
