node{
properties([parameters([string(defaultValue: '127.0.0.1', description: 'Please provide IP host', name: 'IP', trim: true), string(defaultValue: 'latest', description: 'What version would you like to apply?', name: 'VER', trim: true)])])
        try{
            sh "ssh root@${IP} docker rm -f flaskex3"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    
    stage("Run container"){
        sh "ssh root@${IP} docker run -d --name Flaskex -p 6000:4000 vovatran/flaskex_centos7"
    }
}