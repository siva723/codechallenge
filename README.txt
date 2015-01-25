This project is done for the requested made by single value as code challenge. Please go through following in order to build and run this app.

Set you environment.
1) JDK 7
2) Maven 2 or latest
3) eclipse Id
4) Mongodb
5) JQuery and angularjs supported browser
6) Jetty appserver
7) Spark library

How to build this

1) Once you downloaded the source code just launce the maven command > mvn clean install
2) Once build success ->  go to the target and launch the below command 
     java -jar announcement-app-1.0-SNAPSHOT.jar
   
3) You will be getting message as below, 
   
      == Spark has ignited ...
		>> Listening on localhost:8080
		
4) Once its done, now you will be able to access the Announcement application through browser as below url.

	http://localhost:8080

5)Make sure to mongodb up and running and it has db Announcement with column such as ,

	id,
	title,
	body,
	startDate,
	expiryDate
	
	