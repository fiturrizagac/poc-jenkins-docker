node {
    stage('Dockerizando') {

        checkout scm
        
        sh "ls -l"
        docker.withRegistry('https://index.docker.io/v1/', 'docker-hub') {
            def customImage = docker.build("ruby/test:${env.BUILD_ID}")
            customImage.push()
        }
    }
}