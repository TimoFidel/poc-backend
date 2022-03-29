pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean install -X"
            }
        }
       

        stage('deploy') { 
            steps {
                sh "mvn package"
            }
        }


        stage('Build Docker image'){
            steps {
              
                sh 'docker build -t  vaztimofidel/docker_springboot:latest .'
            }
        }
        stage('Docker Login'){
            
            steps {
            
            withCredentials([string(credentialsId: 'Dockerid', variable: 'Dockerpwd')]) {
    // some block
    
                 sh "docker login -u vaztimofidel -p ${Dockerpwd}"
				}
                 
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