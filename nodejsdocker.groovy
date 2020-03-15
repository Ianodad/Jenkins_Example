job('NodeJs Example') {
	scm{
		git('git://github.com/Ianodad/Mailer.git') { node ->
			node / gitConfigName('DSL User')
			node / gitConfigEmail('jenkins-dsl@newtech.academy')
		}
	}
	triggers {
		scm('H/5 * * * *')	
	}
	wrappers {
		nodejs('nodejs')	
	}
	steps {
		dockerBuildAndPublish {
			repositoryName('ianodad/mailer')
			tag('${GIT_REVISION, length=9}')
			registryCredentials('dockerhub')
			forcePull(false)
			forceTag(false)
			createFingerprints(false)
			skipDecorate()		
		}	
	}
}
