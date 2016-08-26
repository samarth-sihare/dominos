#!groovy

node{
   git 'https://github.com/kirankbs/dominos.git'
}
stage 'CLEAN_DEVELOPER_MODULE'
node {
   	sh 'chmod +x gradlew'
  sh './gradlew clean --info'
   }

stage 'BUILD_DEVELOPER_MODULE'
node {
 sh 'chmod +x gradlew'
  sh './gradlew build --info'

   }

stage 'ASSESS_COVERAGE'
node {
   	sh 'chmod +x gradlew'
  sh './gradlew jacoco --info'
   	}

stage 'CLEAR_SEREVR_ADDRESSES'
node{
    sh "kill -9 $(netstat -anlp | grep 9082| awk '{print \$7}'| cut -d'/' -f1)"
}

stage 'START_APPLICATION'
    node {
       sh 'chmod +x gradlew'
       sh './gradlew startApplication'
        }

stage 'SART_FUNCTIONAL_TESTS'
    node {
       sh 'chmod +x gradlew'
       sh './gradlew functionalTest'
        }



stage 'ARCHIVE_ARTIFACTS'
node{
  step([$class: 'ArtifactArchiver', artifacts: '**/build/libs/*.jar', fingerprint: true])
}



