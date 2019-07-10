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
node {
   //stage 'start'
   parallel test
   stage ('middle') {
       sh "echo middle"
   }
   
}
