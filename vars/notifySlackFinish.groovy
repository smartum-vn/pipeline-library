def call() {
    def msg = "`${env.JOB_NAME}` FINISHED"
    slackSend baseUrl: env.SLACK_URL, channel:'backend-data-process' , message: msg, color: '#D4DADF',
        token: 'k3xXZqkEyYfROa7YR92pK9ig'
}
