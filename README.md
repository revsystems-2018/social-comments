# Social Comments

Social Comments project is made up of two modules:

## Social Comment Model

Social Comments Model is responsible to connect and execute the persistence with Set-Fusion.

## Social Comment Service

Social Comments Service is responsible to execute the business logic of each comments requirement, it use Social Comments Model to persist the data.

## Project Dependencies

##### 1.  Java SDK 8 or later
For more details please visit [Download Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html).
```shell
$ java -version
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```

##### 2.  Maven 3.0 or later
For more details please visit [Download Maven](http://maven.apache.org/download.cgi).
```shell
$ mvn --version
Apache Maven 3.5.0 (...)
Maven home: ...
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: ...
Default locale: ...
OS name: ...
```

##### 3.  Git tools
For more details please visit [Download Git](https://git-scm.com/downloads).
```shell
$ git --version
git version 2.10.1 (NNNN Git-78)
```

##### 4.  RabbitMQ
For more details please visit [Install RabbitMQ](https://www.rabbitmq.com/install-windows.html).



## Runtime Dependencies

##### Commons
For more details please visit [Social Common Project](https://git.digitalharbor.us/set/social-common.git).

##### Config Server
For more details please visit [Config Server Project](https://git.digitalharbor.us/set/core-config).

##### Registry Server
For more details please visit [Registry Server Project](https://git.digitalharbor.us/set/core-registry).

##### Gateway Server
For more details please visit [Gateway Server Project](https://git.digitalharbor.us/set/core-gateway).

##### Comments Persistence
That set of services is provided by __Set-Fusion.__
In social-comments yml config, set up as follows:

~~~~{.yml}
persistence:
  service:
    name: default-persistence
    url: http://${set-fusion-persistence-url}:${set-fusion-gateway-port}/comments-persistence
~~~~

##### Rabbit MQ Service
It is used to send asynchronous messages to Comments Service.

##### Registry in EUREKA server
You can registry the service into EUREKA server but is necessary to run first this server on:

```
 http://localhost:8761/eureka/
```

## Configurations

##### bootstrap.yml
The location of the configuration file is:  

`social-comments\comments-service\src\main\resources\bootstrap.yml`

+  Default configurations:

~~~~{.yml}
spring:
  application:
    name: social-comments
  cloud:
    config:
      uri: http://localhost:8888
~~~~

##### social-comments.yml
The location of the configuration file is: 

`social-comments\comments-service\src\main\resources\config-server\social-comments.yml`

+  Default configurations template:

~~~~{.yml}
spring:
  application:
    name: social-commnets
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest

server:
  port: 8999

eureka:
  client:
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
    healthcheck:
      enabled: true

persistence:
  service:
    name: default-persistence
    url: http://${set-fusion-persistence-url}:${set-fusion-gateway-port}/comments-persistence

identity:
  service:
    name: default-identity-service
    url: http://${set-forms-url}:3001
~~~~

Note - The configuration used is specified in core-config project [Config Properties Project](https://git.digitalharbor.us/set/set-devops-aws/tree/develop/deploy-social-service/config-properties).

## Pre Build Project

##### 1.  Clone the project from git repository.
    $ git clone https://git.digitalharbor.us/set/social-common.git
    
##### 2.  Go to project folder.
    $ cd social-common
    
##### 3.  Build and Install Social Common.
    $ mvn clean compile package install

## Build Artifacts

##### 1.  Clone the project from git repository.
   ```
   $ git clone https://git.digitalharbor.us/set/social-comments.git
   ```
    
##### 2.  Go to project folder.
   ```
   $ cd social-comments
   ```
    
##### 3.  Validate the *bootstrap.yml* file configurations, as mentioned earlier.

##### 4.  Build Social Comments model.
   The services *RabbitMQ,* *Config Service,* *Registry Service,* *Gateway Service* and *Comments Persistence* must be started before to start *Social Comments Service*.
   
   For build the artifact social.comment.model go to '\comments-model' folder and execute the console commands:
   
   + __Execute the following command to remove the target directory with all the build data before starting so that it is fresh__: 
   ```
   $  mvn clean
   ```
   
   + __Execute the following command to compile your application sources__: 
   ```
   $  mvn compile
   ```
   
   + __Execute the following command to make a JAR file of project__: 
   ```
   $  mvn package
   ```
   
   
   + __Execute the following command to install this dependence in your local machine__: 
   ```
   $  mvn install
   ```

##### 5.  Build Social Comments
   For build the artifact social.comments.patent return to '\social-comments' folder and execute the console commands:
    
   + __Execute the following command to remove the target directory with all the build data before starting so that it is fresh__:
   ```
   $  mvn clean
   ```
    
   + __Execute the following command to compile your application sources__: 
   ```
   $  mvn compile
   ```
     
   + __Execute the following command to make a JAR file of project__: 
   ```
   $  mvn package
   ```
    
   After that java executable file 'social.comments-1.0-SNAPSHOT.jar' is generated in folder '/comments-service/target'
    

## Run Artifacts

##### Developer Mode

1.  Build the artifacts.
2.  Startup the Local Registry Server.
3.  Update the social-comments.yml file in Local Config Server.
4.  Startup the Local Config Server, Registry Server and Gateway Server.
5.  Startup the Developer Comments Persistence Services (provided by Set-Fusion)
6.  Execute the command: 
    + Run the project with default profile using port default 8999:
    
    `java -jar comments-service/target/social.comments-1.0-SNAPSHOT.jar`
    + Run the project with port assigned:
    
    `java -Dserver.port=${Port} -jar comments-service/target/social.comments-1.0-SNAPSHOT.jar`
    + Run the project with specific profile:
    
    `java -Dspring.profiles.active=YourRabbitMQProfile -jar comments-service/target/social.comments-1.0-SNAPSHOT.jar`

##### Dev-Ops Mode

1.  Build the artifacts.
2.  The Cloud Registry Server already must be started.
3.  Update the social-comments.yml default configurations according the dev-ops deployment plan in Cloud Config Server.
4.  Reload all configurations in Cloud Config Server.
5.  Startup the Cloud Comments Persistence Services (provided by Set-Fusion)
6.  Execute the command: `java -jar comments-service/target/social.comments-1.0-SNAPSHOT.jar`


## Testing

To run the explanation model unit tests you need execute the command:

$ mvn test

To run the explanation model fusion integration tests you need:

- Update the integration-test profile into the application.yml configuration file, it is located in folder 'comments-model/src/test/resources/'

- run the next command:

$ mvn test -P integration-test


## Project Browser Url
The project browser is available on:

```
http://localhost:8999/
```

## Swagger Url

+ __Explanations Swagger Url__: 

```
http://localhost:8999/swagger-ui.html
```

+ __Explanations Swagger Url through Gateway__: 

```
http://localhost:9090/set/social-services/comments/swagger-ui.html
```

## End-point Examples

### Creation of an Comment

For the creation of an explanation, using swagger UI, previously detailed.
Firstly we make a POST request for initialization of an explanation with the following Path:
```
http://localhost:9090/set/social-services/comments/swagger-ui.html#!/resource-rest-controller/initializeResourceExplanationUsingPOST
```

End-Point 
```
http://localhost:9090/set/social-services/comments/resources/{resourceId}/comments/initialize
```

The request will make use of the __resourceId__ parameter and a request body that will be sent in json content type as follows:

~~~~{.json}
{
  "appResourceId": "string",
  "resourceUUID": "string"
}
~~~~

Once inserted successfully you can check with the GET requests.
Now we proceed with the creation of an Message of the Comment, using the following Path:

```
http://localhost:9090/set/social-services/comments/swagger-ui.html#!/user-rest-controller/createExplanationMessageUsingPOST
```

End-Point 
```
http://localhost:9090/set/social-services/comments/users/{userId}/messages
```

The request will make use of the __userId__ parameter required and obtained from the security identity database, also a request body that will be sent in json content type as fallows:
For the variable *explanationId* it is necessary to obtain the result ID of the previous request.
~~~~{.json}
{
  "content": "string",
  "explanationId": ${ID}
}
~~~~
Once inserted successfully you can check with the GET requests. also be able to perform the rest of the requests of DELETE and PUT; that are available in the swagger UI.

### Scripting

In: `comments-model/src/main/resources/script` it is allocated all data patches defined in the project. They are ordered according a number which increases sequentially.

Inside the script file you can find the attribute `release` which represents the __latest official release version.__

To run any of the scripts, you can execute the following command:

```
$ mysql -u USERNAME -pPASSWORD -h HOST -P PORT -D DATABASE_NAME < FILE_NAME.sql
```

Where:

- USERNAME - Username credential in MYSQL instance (the user must have permissions to write the persistence database).
- PASSWORD - Password credential in MYSQL instance.
- HOST - MySQL instance host.
- PORT - MySQL instance port.
- DATABASE_NAME - MySQL database name connection.
- FILE_NAME - Script that you want to run.
