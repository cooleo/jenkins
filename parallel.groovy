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
                   
                    steps {
                        println('Test on Linux')
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
