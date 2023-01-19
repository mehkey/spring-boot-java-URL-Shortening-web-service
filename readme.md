
# URL Shortening Service with Java Spring Boot


![Test code and embed into README](https://github.com/mehkey/spring-boot-java-URL-Shortening-web-service/actions/workflows/gradle.yml/badge.svg)
![Coverage](.github/badges/jacoco.svg)

Java Spring boot URL Shortening Service containing the following components:

+ WebClient Test
+ Controller
+ Service
+ DAO Repository
+ Entity
+ Test SQL
+ Gradle
+ 404 page
+ config file

## Docker Commands

> gradle build

> gradle test

> docker build -t urlshortening .

> docker run -p 8080:8080 --name urlshortening -d urlshortening


## Test Coverage

![Test Coverage](./TestCoverage.png)

