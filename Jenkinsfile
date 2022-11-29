pipeline{
	agent any
	tools{
		maven "M2_HOME"
		jdk 'jdk1.8.0_341'
	}
	stages {
		stage("Build"){
			steps{
				bat "mvn -B compile"
			}
		}
		stage("Test"){
			steps{
				bat "mvn -B test"
			}
		}
	}
	post {
        	always {
            		junit '**/extent/*.html'
			mail to: kmpraveen25@gmail.com, subject: 'The Pipeline passed :'

			}
		
		}
	    

}
