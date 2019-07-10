def test = [:]

test["a"] = {
    stage ("a") {
        stage ("ab") {
            sh "echo stage abc"
        }
        stage ("xyz") {
            sh "echo stage xyz"
        }
    }
}

test["b"] = {
    stage ("b") {
        stage ("bb") {
            sh "echo stage bb"
        }
        stage ("bxz") {
            sh "echo stagebxyz"
        }
    }
}

pipeline {
    agent any;
    options{
        preserveStashes()
    }
    stages {
        stage('stage 1') {
            steps {
                println('stage 1')
            }
            
        }
        
        parallel test
        
        stage('stage end') {
            steps {
              println('stage end')
            }
        }
    }
}
/*node {
   //stage 'start'
   parallel test
   stage ('middle') {
       sh "echo middle"
   }
   
}*/
