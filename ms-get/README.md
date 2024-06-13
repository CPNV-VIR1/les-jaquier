# Kezboards - GET Rest API

This folder is for the microservice that 'GET' keyboards (one or multiple)

## First build
Note : To find out which version of jdk to install in your project, check the pom.xlm file!

* After cloning this repository, to retrieve the dependencies, compile and run the program for the first time, Run this command:

[INPUT]
```
   mvn clean spring-boot:run
```

[OUTPUT]
```
  [...]
    2024-05-30T08:42:27.632+02:00  INFO 1088 --- [kezboards] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
    2024-05-30T08:42:27.640+02:00  INFO 1088 --- [kezboards] [           main] ch.cpnves.kezboards.get.KezboardsApplication     : Started kezboardsApplication in 2.839 seconds (process running for 3.086)
  [...]
```

## Test using http requests

Got the file [project]\src\main\java\ch\cpnves\kezboards\Controllers\EmployeeController.java

Before all routes methods, you will find a curl sample.

[INPUT]
```
curl -i localhost:8080/keyboards
````

[OUTPUT]
```
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Thu, 30 May 2024 06:45:57 GMT

[{"id":1,"name":"El CYPE","housing":"aluminum","numberOfKeycaps":68,"pcbformat":"ANSI"},{"id":2,"name":"Frodo Baggins","housing":"plastic","numberOfKeycaps":104,"pcbformat":"ANSI"},{"id":3,"name":"Gandalf the Grey","housing":"wood","numberOfKeycaps":87,"pcbformat":"ISO"},{"id":4,"name":"Samwise Gamgee","housing":"aluminum","numberOfKeycaps":87,"pcbformat":"ISO"},{"id":5,"name":"Aragorn","housing":"steel","numberOfKeycaps":104,"pcbformat":"ANSI"}]
```

## Collaborate
See the main README.md