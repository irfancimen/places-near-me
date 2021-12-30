# Places near me
This is a case study project rest API using Spring Boot, MongoDB running in docker containers defined by docker-compose yml file.


## Features

- Fetch places near your or specific area on map

## Tech

- [Spring Boot] -  easy to create stand-alone, production-grade Spring based Applications
- [Java 11] - Java SE Development Kit 11.0.11
- [Docker] - Easy container management
- [Google Places API] - Places Map Service
- [Mongo DB] - MongoDB The application data platform


## TL;DR - Build and Run
Will build, package and create a new Docker image with the application
 
```mvn clean package```
 
Launch an Application and a Mongo container

```docker-compose up```

## Docker
The docker file defines a container based on Java with the jar created by maven package, the `dockerfile-maven-plugin` is responsible to build a new image, a push could be configured in the pom file also.

```sh
cd places-near-me
docker build . -t pnm-app
```

```sh
docker run -d -p 8070:8070 pnm-app
```

## Docker-compose
The Docker-compose file describes our multi-container application, the application consists in 2 containers, one running the pnm-app and a linked container with MongoDB. These containers have the 8070 port exposed for the RestAPI and 27017 for mongo


This is just a initial implementation to be used as example exercising Spring boot, Docker, MongoDB. Another features and technologies will be added to this project.

   [Spring Boot]: <https://spring.io/projects/spring-boot>
   [Java 11]: <https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html>
   [Docker]: <https://www.docker.com/>
   [Google Places API]: <https://developers.google.com/maps/documentation/places/web-service/overview/>
   [Mongo DB]: <https://www.mongodb.com/>
 
## Some User Interface Screenshots
![firstss](https://user-images.githubusercontent.com/20202301/147772124-728bb9e5-063b-4a3c-888c-06f87f4eba9c.JPG)

![queryss](https://user-images.githubusercontent.com/20202301/147772134-ce824855-a089-432d-917f-c3a7fcc29588.JPG)

![validationss](https://user-images.githubusercontent.com/20202301/147772142-29427b68-2800-4db6-803a-136dcd1fe29b.JPG)
