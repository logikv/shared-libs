def call(Map config = [:]){
pipeline {
       agent any
       tools {
           maven 'M3'
           jdk "${config.jdkVersion}"
       }
       parameters {
         booleanParam name: 'ENV_IS_PROD', defaultValue: false
       }

       
       stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'master',
                       url: "${config.gitUrl}"
               }
           }
           stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }
           stage("Running Testcase") {
              steps {
                   sh "mvn test"
               }
           }
           stage("Packing Application") {
               steps {
                   sh "mvn package -DskipTests"
               }
           }
       }
 }

}
