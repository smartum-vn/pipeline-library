def call(String instanceId, String type, boolean stopAfterScaleDown) {

    STATE = sh(returnStdout: true, script: "echo \$(aws ec2 describe-instances --instance-ids $instanceId --output text --query Reservations[*].Instances[*].State.Name)")
    TYPE = TYPE.replaceAll("\\s", "")

        if (STATE == "running") {
            sh "aws ec2 stop-instances --instance-ids $instanceId"
            sh "aws ec2 wait instance-stopped --instance-ids $instanceId"
        }
        sh "aws ec2 modify-instance-attribute --instance-id $instanceId --instance-type $type"
        if(!stopAfterScaleDown)
        {
        sh "aws ec2 start-instances --instance-ids $instanceId"
        sh "aws ec2 wait instance-running --instance-ids $instanceId"
        }
}
