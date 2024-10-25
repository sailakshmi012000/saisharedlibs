def call(credId,user,ip){
   sshagent([credId]) {
                // rename
                sh "mv target/myweb-0.0.9*.war target/myweb.war"
                //copy
                sh "scp -o StrictHostKeyChecking=no target/myweb.war ${user}@${ip}:/opt/tomcat9/webapps"
                //stop
                sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
                //start
                sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
                }
}
