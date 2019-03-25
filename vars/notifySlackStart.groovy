def call() {
    def msg = "*[${now}]*  `${env.JOB_NAME}` STARTED `DO NOT TOUCH`"
    slackSend baseUrl: env.SLACK_URL, channel: 'backend-data_process' , message: msg, color: '#D4DADF',
        token: 'KTt42sxU8xU1jTF3Ix3pwI13'
}
