# totalhrmanagement
How to compile the application:

mvn clean package

How to run the application:

mvn appengine:run


Manage your HR Resources

This application allows you to register your company, add your responsible and your job offers.

Also candidates can register and subscribe to those job offers.

In your local environment the file local_db.bin represents the datastore, and is located under the WEB-INF appengine-generated directory.

Your could generate the directory:

mkdir target/totalhrmanagement-1.0-SNAPSHOT/WEB-INF/appengine-generated

And copy a back up of the datastore:

cp local_db.bin target/totalhrmanagement-1.0-SNAPSHOT/WEB-INF/appengine-generated/.

If you have a local installation of the CI/CD Teamcity server this is the way you start the server and the agent

Starting the Team City build server:
/Applications/TeamCity/bin/startup.sh run

Starting the Team City build agent:
/Applications/buildAgent/bin/agent.sh start

grep token /Applications/TeamCity/catalina.out