pipeline {
    agent none
    stages {
        stage('Run Tests') {
            parallel {
                stage('Test On Windows') {
                    
                    steps {
                       println('Test on Windows')
                    }
                    
                }
                stage('Test On Linux') {
                    stage('Test on Linux 1') {
                        steps {
                           println('Test on Linux 1)
                        }
                    }
                 stage('Test on linux 2') {
                     steps{
                        println('Test on Linux 2')
                     }
                 }
                    
                }
                
            }
        }
        stage('Deployment') {
            steps {
                println('Deployment')
            }
        }
    }
}
