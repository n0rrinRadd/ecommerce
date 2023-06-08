def addToResult(result, value) {
  return result.length ? (result + " & " + value) : value;
}

def buildTags() {
  return "e2eShakedown";
}

properties([
  parameters([
    string(name: 'baseUrl', defaultValue: '', description: '')
  ])
])

def sendNotification(color, status) {
    slackSend channel: "#search-test", color: "${color}", message: "${status}: Regression Tests \n Coverage: Search & Browse \n Environment: ${params.baseUrl} \n Build: ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
}

pipeline {
  agent {
      label 'amzlnx2'
  }

  environment {
    ARTIFACTORY_URL = 'https://ecommerceinc.jfrog.io'
    ARTIFACTORY_USER = credentials('artifactory-username')
    ARTIFACTORY_PASSWORD = credentials('artifactory-password')
    CXX = 'g++48'
    NODE_ENV = 'production'
    LC_ALL = 'en_US.UTF-8'
    LANG    = 'en_US.UTF-8'
    LANGUAGE = 'en_US.UTF-8'
  }

  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        sh "./gradlew clean build -x test"
      }
    }
    stage('Run End to End Feature Tests') {
      when {
        expression { params.baseUrl }
      }
      steps {
        script {
          echo 'Executing feature tests....'
          if (params.baseUrl.contains("sfw") || params.baseUrl.contains("dev"))
          {
            sh("./gradlew clean cucumber -Dcucumber.options=\"--tags @dev\" -DbrowserEnv=grid -DbrowserType=chrome -DbrowserVersion=latest -DbaseUrl='${params.baseUrl}'")
          }
          else {
            sh("./gradlew clean cucumber -Dcucumber.options=\"--tags @qat\" -DbrowserEnv=grid -DbrowserType=chrome -DbrowserVersion=latest -DbaseUrl='${params.baseUrl}'")
          }

        }
      }
    }
  }

  post {
    //always {
      // echo 'Uploading results to TestRail...'
      // this tasks takes upwards of 15 minutes
      // sh "./gradlew upload -PbaseUrl=${params.baseUrl} -Pbranch=${BRANCH_NAME}"
    //}
    success {
      sendNotification("#5cb58a", "SUCCESSFUL")
    }
    failure {
      sendNotification("#961d13", "FAILED")
    }
  }
}
