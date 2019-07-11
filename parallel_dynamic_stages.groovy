pipeline {
    agent { label "master"}
    stages {
        stage('Paralell dynamic stages') {
            steps {
                script {
                    def tests = [:]
                    for (f in findFiles(glob: '**/html/*.html')) {
                        tests["${f}"] = {
                            node {
                                stage("${f}") {
                                    echo '${f}'
                                }
                            }
                        }
                    }
                    parallel tests
                }
            }
        }       
    }
}
