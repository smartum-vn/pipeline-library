def call() {
    def msg = "*[${now}]*  `${env.JOB_NAME}` STARTED ` DO NOT TOUCH "
    slackSend baseUrl: env.SLACK_URL, channel: 'backend-data_process' , message: msg, color: '#D4DADF', token: 'k3xXZqkEyYfROa7YR92pK9ig'
}
