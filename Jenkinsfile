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

stage 'CLEAR_SEREVR_ADDRESSES'
node{
       sh 'chmod +x gradlew'
       sh './gradlew clearApplicatioPorts'
}   

stage 'ASSESS_COVERAGE'
node {
   	sh 'chmod +x gradlew'
  sh './gradlew jacoco --info'
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



