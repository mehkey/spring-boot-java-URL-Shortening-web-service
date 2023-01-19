
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


# URL Redirect API

This API allows for the redirecting of shortened URLs to their original, full URLs.

## Endpoints

### GET `/{shortUrl}`

Redirects the user to the full URL associated with the given short URL.

#### Parameters

- `shortUrl`: (required) The shortened URL.

#### Responses

- `302 Found`: The user is successfully redirected to the full URL.

- `404 Not Found`: The provided short URL is not valid or has expired.



# URL Shortener API

This API allows for the creation and retrieval of shortened URLs.

## Endpoints

### GET `/url/{id}`

Retrieves the URL associated with the given id.

#### Parameters
- `id`: (required) The id of the URL.

#### Responses
- `200 OK`: The URL is successfully retrieved and returned in the response body.
- `404 Not Found`: The provided id does not match any existing URLs.

### POST `/url`

Creates a new shortened URL.

#### Parameters
- `url` : (required) the original URL

#### Responses
- `201 Created`: The URL is successfully created and the location of the new resource is returned in the `Location` header.
- `400 Bad Request`: The provided url or short url is not valid.

### GET `/url/all`

Retrieves all the URLs.

#### Responses
- `200 OK`: A list of all the URLs is returned in the response body.


### GET `/urls`

Retrieves all the URLs.

#### Responses
- `200 OK`: A an HTML page with a list of URLs and a form to submit new URLS.

e.g.

![UI](./UI.png)



## Test Coverage

![Test Coverage](./TestCoverage.png)

