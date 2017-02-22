pipeline {
    agent any
    parameters {
        string (
            defaultValue: '*',
            description: '',
            name : 'BRANCH_PATTERN')
        booleanParam (
            defaultValue: false,
            description: '',
            name : 'FORCE_FULL_BUILD')
    }

    stages {
        stage ('Pullrequest for code') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: "origin/${BRANCH_PATTERN}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'LocalBranch']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        credentialsId: 'a1a2265a-6c99-43cd-941d-62ee5b4b10e1',
                        url: 'https://github.com/Shiva243/FIM.git']]])
            }
        }
   
    }
}
