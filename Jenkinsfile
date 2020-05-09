pipeline {
  environment {
    registry = "iamdhruvp/devops"
    registryCredential = 'DockerHubCred'
    dockerImage = ''
  }
  agent any
  stages {
    stage('GIT CLONE') {
      steps {
        git 'https://github.com/iamdhruvp/SPE_Assignment.git'
      }
    }
    stage('MVN COMPILE') {
      steps {
        echo "Compiling the source Java classes of the project"
		sh "mvn compile"
      }
    }
    stage('MVN TEST') {
      steps {
        echo "Running the test cases of the project"
        sh "mvn test"
      }
    }
    stage('MVN INSTALL') {
      steps {
        echo "building the project and installs the project files(JAR) to the local repository"
        sh "mvn install"
      }
    }
    stage('Building Docker image') {
      steps{
        script {
          echo "Building Docker image"
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Docker Image') {
      steps{
        script {
          echo "Deploying Docker Image to " + registry
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push('latest')
          }
        }
      }
    }
    stage('Remove Unused untagged docker images') {
      steps{
        sh "docker image prune"
      }
    }
    stage('Deploy on Node') {
      steps {
        script {
          step([
            $class: "RundeckNotifier",
            includeRundeckLogs: true,
            rundeckInstance: "Rundeck server",
            jobId: "800e3eee-626d-4477-b485-a528acd2f593",
            shouldWaitForRundeckJob: true,
            shouldFailTheBuild: true,
            tailLog: true
          ])
        }
      }
    }
  }
}