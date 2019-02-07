# Sample Spring Boot Application using Logback AMQP Appender.

A simple [Spring Boot](http://projects.spring.io/spring-boot/) Application demonstrating
the use of the [Logback](https://logback.qos.ch/) AMQP Appender.  

Build & run 
-----------

**Prerequisites:**

* Java 8
* Apache Maven (https://maven.apache.org/)
* RabbitMQ (https://www.rabbitmq.com/)

Sample consists of a producer and a receiver Module.

Use

```
mvn clean install
```
to build the Application and

```
java -jar logback-amqp-sample/logmessage-receiver/target/logmessage-receiver-1.0-SNAPSHOT.jar
```

to start the Log Message Receiver and 

```
java -DAMQP_APP_ID=PROD_X -jar logback-amqp-sample/logmessage-producer/target/logmessage-receiver-1.0-SNAPSHOT.jar
```
to start one or more Message Producer Instances.
