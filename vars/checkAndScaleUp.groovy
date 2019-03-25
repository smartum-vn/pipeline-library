def call(String instanceId, String type) {
    
    STATE = sh(returnStdout: true, script: "echo \$(aws ec2 describe-instances --instance-ids $instanceId --output text --query Reservations[*].Instances[*].State.Name)")
    TYPE = sh(returnStdout: true, script: "echo \$(aws ec2 describe-instances --instance-ids $instanceId --output text --query Reservations[*].Instances[*].InstanceType)")
    if (TYPE != type) {
        if (STATE == "running") {
            sh "aws ec2 stop-instances --instance-ids $instanceId"
            sh "aws ec2 wait instance-stopped --instance-ids $instanceId"
        }
        
        sh "aws ec2 modify-instance-attribute --instance-id $instanceId --instance-type $type"
        sh "aws ec2 start-instances --instance-ids $instanceId"
        sh "aws ec2 wait instance-running --instance-ids $instanceId"
    }
}
