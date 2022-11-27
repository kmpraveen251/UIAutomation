pipeline{
	agent any
	tools{
		maven 'Maven'
	}
	stages {
		stage("build"){
			steps{
				sh 'mvn -B compile'
			}
		}
		stage("test"){
			steps{
				sh 'mvn -B clean install'
			}
		}
		stage("Archive"){
			steps{
				archiveArtifacts 'target/*.jar'
			}
		}
	}
}
