def call() {
    def now = new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone('UTC'))
    def msg = "*[${now}]*  `${env.JOB_NAME}` ${env.STAGE_NAME} `STARTED`"
    slackSend baseUrl: env.SLACK_URL, channel: 'backend_data-process', message: msg, color: '#D4DADF',
        token: 'ATA1vsRzCd7fL3T8AsBceh9X'
}
