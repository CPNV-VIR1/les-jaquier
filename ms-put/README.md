# Kezboards - PUT Rest API

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
    2024-05-30T08:42:27.640+02:00  INFO 1088 --- [kezboards] [           main] ch.cpnves.kezboards.put.KezboardsApplication     : Started kezboardsApplication in 2.839 seconds (process running for 3.086)
  [...]
```

## Test using http requests

[INPUT]
```
curl -i -X PUT localhost:8080/keyboards/2 \
    -H "Content-Type: application/json" \
    -d '{"name": "Russel George", "PCBFormat": "ANSI", "housing": "plastic", "numberOfKeycaps": 140}'
````

[OUTPUT]
```
HTTP/1.1 200 
Server: nginx/1.27.0
Date: Thu, 13 Jun 2024 08:33:08 GMT
Content-Type: application/json
Transfer-Encoding: chunked
Connection: keep-alive

{"id":2,"name":"Russel George","housing":"plastic","numberOfKeycaps":140,"pcbformat":null}
```

## Collaborate
See the main README.md