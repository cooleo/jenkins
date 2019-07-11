
def getListStages() {
    String[] arrStr = ["Stage Test 1", "Stage Test 2", "Stage Test 3"]
    return arrStr

}

pipeline {
    agent { label "master" }
    stages {
        stage('Paralell dynamic stages') {
            steps {
                script {
                    def stageList = [:]
                    def stageNames = getListStages()
                    for (String stageName : stageNames) {
                        stageList["${stageName}"] = {
                           node {
                                stage("${stageName}") {
                                    echo '${stageName}'
                                }
                           }
                        }
                    }
                    parallel stageList
                }
            }
        }
    }
}
