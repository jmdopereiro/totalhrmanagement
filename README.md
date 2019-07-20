# totalhrmanagement
How to compile the application:

mvn clean package

How to run the application:

mvn appengine:run


Manage your HR Resources

This application allows you to register your company, add your responsible and your job offers.

Also candidates can register and subscribe to those job offers.

To keep the datastore:

Joses-MacBook-Air:totalhrmanagement josemanueldopereiro$ mkdir target/totalhrmanagement-1.0-SNAPSHOT/WEB-INF/appengine-generated

Joses-MacBook-Air:totalhrmanagement josemanueldopereiro$ cp /Users/josemanueldopereiro/local_db.bin target/totalhrmanagement-1.0-SNAPSHOT/WEB-INF/appengine-generated/.


Starting the Team City build server:
/Applications/TeamCity/bin/startup.sh run

Starting the Team City build agent:
/Applications/buildAgent/bin/agent.sh start

grep token /Applications/TeamCity/catalina.out