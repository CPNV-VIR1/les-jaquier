# Keyboards - Dockerized Rest API

This repository is an example of an api rest spring application using docker.

## Prerequisites
* AWS CLI v2.13 or later [official doc](https://aws.amazon.com/cli/)
* IntelliJ IDEA Ultimate or later [official doc](https://www.jetbrains.com/idea/download/?section=windows)
* IntelliJ Docker plugin [official doc](https://plugins.jetbrains.com/plugin/7724-docker/versions#tabs)
* Docker V23 or later [official doc](https://www.docker.com/products/docker-desktop/)
* git version 2.44 or later [official doc](https://git-scm.com/)
* (maven v3.9 or later [official doc](https://maven.apache.org/download.cgi))
* (JDK 17 [official doc](https://www.oracle.com/java/technologies/downloads/))

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
    2024-05-30T08:42:27.632+02:00  INFO 1088 --- [payroll] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
    2024-05-30T08:42:27.640+02:00  INFO 1088 --- [payroll] [           main] ch.cpnves.payroll.PayrollApplication     : Started PayrollApplication in 2.839 seconds (process running for 3.086)
    2024-05-30T08:42:27.684+02:00  INFO 1088 --- [payroll] [           main] c.c.payroll.Repositories.LoadDatabase    : Preloading Employee{id=1, name='Bilbo Baggins', role='burglar'}
    2024-05-30T08:42:27.685+02:00  INFO 1088 --- [payroll] [           main] c.c.payroll.Repositories.LoadDatabase    : Preloading Employee{id=2, name='Frodo Baggins', role='thief'}
  [...]
```

## Test using http requests

Got the file [project]\src\main\java\ch\cpnves\payroll\Controllers\EmployeeController.java

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

## Deploy with docker
Deploy a postgresql, the spring api app and (in future) a NGinx API Gateway.
```
docker compose up
````
You can try with 
```
curl -i localhost:8080/keyboards
````

## Collaborate

* Workflow
    * [Gitflow](https://www.atlassian.com/fr/git/tutorials/comparing-workflows/gitflow-workflow#:~:text=Gitflow%20est%20l'un%20des,les%20hotfix%20vers%20la%20production.)
    * [How to commit](https://www.conventionalcommits.org/en/v1.0.0/)
    * [How to use your workflow](https://nvie.com/posts/a-successful-git-branching-model/)

    * Pull requests are open to merge in the develop branch.
    * Release on the main branch we use GitFlow and not with GitHub release.
    * Use snake_case for branches. (example : feature/nginx_api_gateway)
    * Issues are added to the github issues page