node {
    stage('Dockerizando') {

        checkout scm
        
        sh "ls -l"
        sh "ls -l ../"
        //sh "ls -l ../another_test@script"
        sh "pwd"
        // sh "ls -l /var/jenkins_home/workspace/another_test@tmp"
        // sh "ls -l /var/jenkins_home/workspace/another_test@tmp/durable-9c83888a"
        // sh "cat /var/jenkins_home/workspace/another_test@tmp/durable-9c83888a/script.sh"
        //sh "ls -R ../ | awk '/:\$/&&f{s=\$0;f=0}/:\$/&&!f{sub(/:\$/,\"\");s=\$0;f=1;next}NF&&f{ print s\"/\"\$0 }'"
        //sh "ls -R ../ | awk '/:\$/&&f{s=\$0;f=0}/:\$/&&!f{sub(/:\$/,\"\");s=\$0;f=1;next}NF&&f{ print s\"/\"\$0 }'"

        //sh "cat \$(ls -R ../ | awk '/:\$/&&f{s=\$0;f=0}/:\$/&&!f{sub(/:\$/,\"\");s=\$0;f=1;next}NF&&f{ print s\"/\"\$0 }' | grep script.sh)"
        
        //sh "docker ps -a"
        docker.withRegistry('', 'dockerhub') {
            def customImage = docker.build("fiturrizaga/rubytest:${env.BUILD_ID}")
            customImage.push()
        }
    }
}