node {
    stage('Dockerizando') {

        checkout scm
        
        sh "ls -l"
        sh "ls -l ../"
        sh "ls -l ../another_test@script"
        sh "pwd"
        // sh "ls -l /var/jenkins_home/workspace/another_test@tmp"
        // sh "ls -l /var/jenkins_home/workspace/another_test@tmp/durable-9c83888a"
        // sh "cat /var/jenkins_home/workspace/another_test@tmp/durable-9c83888a/script.sh"
        sh "ls -R . | awk '/:$/&&f{s=$0;f=0}/:$/&&!f{sub(/:$/,"");s=$0;f=1;next}NF&&f{ print s"/"$0 }'"
        sh "docker ps -a"
        docker.withRegistry('https://index.docker.io/v1/', 'docker-hub') {
            def customImage = docker.build("ruby/test:${env.BUILD_ID}")
            customImage.push()
        }
    }
}