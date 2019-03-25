def call() {
    sh 'aws ec2 describe-instances --instance-ids i-0ca541748d138bbe4 --output text --query Reservations[*].Instances[*].State.Name'
    sh 'aws ec2 stop-instances --instance-ids i-0ca541748d138bbe4'
    sh 'aws ec2 wait instance-stopped --instance-ids i-0ca541748d138bbe4'
    sh 'aws ec2 modify-instance-attribute --instance-id i-0ca541748d138bbe4 --instance-type t2.medium'

    sh 'aws ec2 start-instances --instance-ids i-0ca541748d138bbe4'
    sh 'aws ec2 wait instance-running --instance-ids i-0ca541748d138bbe4'
    sh 'aws ec2 describe-instances --instance-ids i-0ca541748d138bbe4 --output text --query Reservations[*].Instances[*].State.Name'
}
