pipeline {
    agent any 
    stages {

		stage('maven clean and install'){
            steps {
              
                bat 'mvn clean install'
            }
        }
        

        
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}