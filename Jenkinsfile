pipeline {
    agent any 
    stages {

		stage('Build Docker image'){
            steps {
              
                bat 'docker build -t  vaztimofidel/docker_springboot:latest .'
            }
        }
        


        stage('Docker Push'){
            steps {
                bat 'docker push vaztimofidel/docker_springboot:latest'
            }
        }
        
        stage('Docker deploy'){
            steps {
               
                bat 'docker run -itd -p  8081:8080 vaztimofidel/docker_springboot:latest'
            }
        }

        
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}