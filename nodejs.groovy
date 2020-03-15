job('NodeJs Example') {
	scm{
		git('git://https://github.com/Ianodad/Mailer.git') node -> {
			node / gitConfigName('DSL User)
			node / gitConfigEmail('jenkins-dsl@newtech.academy')
		}
	}
	triggers {
		scm('H/S * * * *')	
	}
	wrappers {
		nodejs('nodejs')	
	}
	steps {
		shell("npm install")	
	}
}
