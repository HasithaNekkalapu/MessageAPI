# MessageAPI

 The jar file can be run by using following command
 
 --> java -jar interview-0.0.1-SNAPSHOT.jar
 
 The following steps need to the done in order
 
 a) maven clean install
 
 b) maven build
 
 c) Run /interview/src/main/java/com/remesh/interview/InterviewApplication.java
    This is the start point of the application
 
 --> I have used the RestTemplate to call the services and fetched the response to perform filtering.
 
 --> Swagger is used for the Rest APIs
 
 d) http://localhost:9090/swagger-ui.html#!/controller/ will give the REST APIs available.
 
 e) GIve the parameters and click try it out button.
 
 --> For example if age= 60-64 and 65+ the input should be 60-64OR65+
 
 --> AND can't be used in the query
