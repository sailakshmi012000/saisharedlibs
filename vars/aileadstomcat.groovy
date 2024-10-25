def call(credId,user,ip){
      sshagent([credId]){
                    //rename
                    sh "mv target/ai-leads*.war target/leads.war"
                    //copy war
                    sh "scp -o StrictHostKeyChecking=no target/leads.war ${user}@${ip}:/opt/tomcat9/webapps"
                    //stop&start jenkins
                    sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
                    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
                }
}
