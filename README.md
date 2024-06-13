# Kezboards - Dockerized Rest API

This repository is an example of an api rest spring application using docker with each microservices being a http verb.

## Getting Started
### Prerequisites
* AWS CLI v2.13 or later [official doc](https://aws.amazon.com/cli/)
* IntelliJ IDEA Ultimate or later [official doc](https://www.jetbrains.com/idea/download/?section=windows)
* IntelliJ Docker plugin [official doc](https://plugins.jetbrains.com/plugin/7724-docker/versions#tabs)
* Docker V23 or later [official doc](https://www.docker.com/products/docker-desktop/)
* git version 2.44 or later [official doc](https://git-scm.com/)
* (maven v3.9 or later [official doc](https://maven.apache.org/download.cgi))
* (JDK 17 [official doc](https://www.oracle.com/java/technologies/downloads/))

#### NOTE FOR WINDOWS USERS
All curl commands are executed in GitBash and use mingw implementation (more close to UNIX one that powershell).
See [Git for Windows](https://gitforwindows.org/) for more information and download.

### Configuration
Copy the '.env.example' to '.env' and set the environment variables for your needs (this will be mainly used for docker compose configuration and deployment).

## Deployment
If you only want to build a single microservice (with Dockerfile or directly using maven), see the "ms-[http-verb]"/README.md
### Deploy locally (docker)
Deploy a postgresql, all the spring api microservices and a NGinx API Gateway.
```
docker compose up --build
````
You can try with
```
curl -i localhost:8080/keyboards
````

### Deploy remotely (docker)
SSH to your production and add the following content to a .env file (replace the password)
```dotenv
DB_NAME=kezboard
DB_USER=kezboard
DB_PASSWORD=kezboard
````
Push the precompiled .tar(s) to production with SCP (based on your .env config)
```
cd ./deployment
sh push-to-prod.sh
````
Note : On windows, execute this with Git Bash.


## Test using http requests

Go to the files [project]\ms[http-verb]\src\main\java\ch\cpnves\kezboards\[http-verb]\Controllers\KeyboardController.java

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

## Directory structure

* Tip: try the tree bash command

```shell
├───.github
│   └───workflows                //Github action with matrixes
├───ms-[post, get, put, db, ...] //Consider these folders as a standalone repo. Should not have dependencies with other folders
│   ├───README.md                //Provide a README for just the standalone microservice
│   ├───Dockerfile
│   ├───pom.xml
│   └───src                      //The structure below src can vary depending the language /appverifUI.dll framework (Here, a java spring microservice)
│       └───main
│           ├───java.ch.cpnves...[delete, post, get, put]
│           │   ├───Controllers
│           │   ├───Entities
│           │   └───Repositories
│           └───resources
├───docs
├───compose*.yaml                //Dev and production docker compose
├───*.sh                         //All the script to deploy remotely
├───.env
└───README.md                    //The root files (like README) are only describing the combinaison of microservices with docker
```

## Collaborate

* Workflow
    * [Gitflow](https://www.atlassian.com/fr/git/tutorials/comparing-workflows/gitflow-workflow#:~:text=Gitflow%20est%20l'un%20des,les%20hotfix%20vers%20la%20production.)
    * [How to commit](https://www.conventionalcommits.org/en/v1.0.0/)
    * [How to use your workflow](https://nvie.com/posts/a-successful-git-branching-model/)

    * Pull requests are open to merge in the develop branch.
    * Release on the main branch we use GitFlow and not with GitHub release.
    * Use snake_case for branches. (example : feature/nginx_api_gateway)
    * Issues are added to the github issues page