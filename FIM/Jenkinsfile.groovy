def devStaging() {
    stage 'checkout from git'{
        echo 'test';
         git credentialsId: 'a1a2265a-6c99-43cd-941d-62ee5b4b10e1', url: 'https://github.com/Shiva243/FIM.git'

    }
}
