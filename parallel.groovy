pipeline {
    agent any;
    options {
        preserveStashes()
    }
    stages {
        stage('Run Tests') {
            parallel {
                stage('Test On Windows') {
                    
                    steps {
                       
                             print('Test windows 1')
                       
                    }
                    
                }
                stage('Test On Linux') {
                   
                    steps {
                         print('Test Linux 1')
                    }
                   
                }
            }
        }
    }
}
