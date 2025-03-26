def call (ip,user,cred){
  stage("tomcat deploy"){
            steps{
                sshagent([cred]) {
                    // copy war file
                    sh "scp -o StrictHostKeyChecking=no target/ai-leads.war ${user}@${ip}:/opt/tomcat9/webapps"
                    // shutdown
                    sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
                    //start
                    sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
                }
            }
        }
}
