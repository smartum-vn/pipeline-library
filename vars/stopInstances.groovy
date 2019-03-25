def call(String[] instances) {
    for (int i = 0; i < instances.size(); i++) {
        def instance = instances[i]
        def state = sh(returnStdout: true, script: "echo \$(aws ec2 describe-instances --instance-ids $instanceId --output text --query Reservations[*].Instances[*].State.Name)")
        state = state.replaceAll("\\s", "")
        if (state != 'stopped') {
            sh "aws ec2 stop-instances --instance-ids $instance"
            sh "aws ec2 wait instance-stopped --instance-ids $instance"
        }
    }
}
