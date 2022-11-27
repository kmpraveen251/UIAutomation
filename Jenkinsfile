pipeline{
	agent any
	stages {
		stage("build"){
			steps{
				bat 'mvn -B compile'
			}
		}
		stage("test"){
			steps{
				bat 'mvn -B clean install'
			}
		}
		stage("Archive"){
			steps{
				archiveArtifacts "target/*.jar'
			}
		}
	}
	post{
		always{
		}
	}
}
