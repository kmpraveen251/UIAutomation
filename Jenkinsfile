pipeline{
	agent any
	tools{
		maven "3.8.6"
		jdk 'jdk1.8'
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
}
