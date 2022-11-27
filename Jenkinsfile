pipeline{
	agent any
	tools{
		maven 'Maven'
	}
	stages {
		stage("build"){
			steps{
				bat "mvn compile"
			}
		}
		stage("test"){
			steps{
				bat "mvn test"
			}
		}
	}
}
