pipeline {
    agent any 
    stages {

		stage('Docker Login'){
            
            steps {
            
    // some block
    
                 sh "docker login -u vaztimofidel -p ${Timorihi$-99}"
				
                 
            }                
        }
        stage('Build Docker image'){
            steps {
              
                sh 'docker build -t  vaztimofidel/docker_springboot:latest .'
            }
        }
        


        stage('Docker Push'){
            steps {
                sh 'docker push vaztimofidel/docker_springboot:latest'
            }
        }
        
        stage('Docker deploy'){
            steps {
               
                sh 'docker run -itd -p  8081:8080 vaztimofidel/docker_springboot:${BUILD_NUMBER}'
            }
        }

        
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}