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

stage 'START_APPLICATION'
parallel(services: {
            startApp("run --no-daemon")
   	}, ui:{
            startApp("runUI --no-daemon")
   	})

def startApp(command) {
    node {
       sh 'chmod +x gradlew'
       sh './gradlew ${command}'
        }
    }


stage 'ARCHIVE_ARTIFACTS'
node{
  step([$class: 'ArtifactArchiver', artifacts: '**/build/libs/*.jar', fingerprint: true])
}



