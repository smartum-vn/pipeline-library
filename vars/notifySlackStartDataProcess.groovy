def call() {
    def msg = "*[${now}]*  `${env.JOB_NAME}` STARTED `DO NOT TOUCH`"
    slackSend baseUrl: env.SLACK_URL, channel: 'backend_data-process' , message: msg, color: '#D4DADF',
        tokenCredentialId: '48d3251e-a5f1-4ab5-821c-e75d5868ff65'
}
