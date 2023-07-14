pipeline {
    agent any
    tools{
        maven 'MAVEN_3.9.2'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/bhavesh-zanzane-2911/Rest-Api-Practice']]])
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests'){
                    steps{
                        bat 'mvn test'
                    }
        }
		
		stage('SonarQube analysis') {
		                steps{
		                   script{
                                 withSonarQubeEnv(installationName: 'SonarQube') { 
                                 bat 'mvn sonar:sonar'
                                 }
		                   }
						}
        }

        stage('Build docker image'){
                            steps{
                                script{
                                    bat 'docker build -t bhaveshzanzane/docker-practice .'
                                }
                 }
         }

        
         stage('Push image to Hub'){
                     steps{
                         script{
                            withCredentials([string(credentialsId: 'DockerPassword', variable: 'DockerPassword')]) {
                            bat 'docker login -u bhaveshzanzane -p bhaveshzanzane'

         }
                            bat 'docker push bhaveshzanzane/docker-practice'
                         }
                     }
                 }



   }
}
