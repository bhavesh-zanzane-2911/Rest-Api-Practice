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

        stage('Build docker image'){
                            steps{
                                script{
                                    bat 'docker build -t bhaveshzanzane/docker-practice.jar .'
                                }
                 }
         }
         stage('Push image to Hub'){
                     steps{
                         script{
                            withCredentials([usernamePassword(credentialsId: 'd3bb2215-b4bf-47fb-a547-0016b8466f51', passwordVariable: 'password', usernameVariable: 'username')]) {
     bat 'docker login -u ${username} -p ${password}'
}
                            bat 'docker push bhaveshzanzane/docker-practice.jar'
                         }
                     }
                 }



   }
}
