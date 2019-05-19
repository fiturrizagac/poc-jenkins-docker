node {
    stage('Dockerizando') {

        checkout scm
        
        sh "ls -l"
        sh "$(pwd)"
        sh "cat script.sh"
        sh "docker ps -a"
        docker.withRegistry('https://index.docker.io/v1/', 'docker-hub') {
            def customImage = docker.build("ruby/test:${env.BUILD_ID}")
            customImage.push()
        }
    }
}