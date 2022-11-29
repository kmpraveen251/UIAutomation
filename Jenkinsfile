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
		stage ('email')
		    {
			emailext (
			subject: "some subject",
			body: 'text'
			to: "kmpraveen25@gmail.com")
			 
    		}

	}
	 

}
