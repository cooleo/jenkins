

pipeline {
    agent none
    options {
        preserveStashes()
    }
    stages {
        stage("pre-restart") {
            agent any
            steps {
                dir("test-dir") {
                    writeFile(file: "someFile", text: env.BUILD_NUMBER)
                    stash(name: 'stash-test', includes: 'someFile')
                    deleteDir()
                }
            }
        }

        stage('post-restart') {
            agent any
            steps {
                unstash 'stash-test'
                echo "someFile is ${readFile('someFile')}"
                unstash 'stash-test'
                echo "someFile is ${readFile('someFile')}"
                unstash 'stash-test'
                echo "someFile is ${readFile('someFile')}"
            }
        }

        stage('next-restart') {
            agent any
            steps {
                unstash 'stash-test'
                echo "someFile is ${readFile('someFile')}"
                unstash 'stash-test'
                echo "someFile is ${readFile('someFile')}"
                unstash 'stash-test'
                echo "someFile is ${readFile('someFile')}"
            }
        }
    }
}
