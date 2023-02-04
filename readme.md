
# URL Shortening Service with Java Spring Boot


![Test code and embed into README](https://github.com/mehkey/spring-boot-java-URL-Shortening-web-service/actions/workflows/gradle.yml/badge.svg)
![Coverage](.github/badges/jacoco.svg)

CI/CD Badge for Build Success and Percentage of Lines of code Coverage for Tests created using using [Github Actions](https://github.com/mehkey/spring-boot-java-URL-Shortening-web-service/actions)

## [Original Design for URL Shortening Service](https://github.com/mehkey/system-design/tree/main/designs/URLShortner)

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
+ docker compose for Redis and Postgres

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

Example Request:
HTTP/1.1


Example Response:
HTTP/1.1 200 OK
Content-Type: application/json


```json

{
    "id": 1,
    "url": "https://www.example.com",
    "createdDate": "2022/01/01 12:00:00",
    "shortUrl": "https://localhost/1"
}
```

### POST `/url`

Creates a new shortened URL.

#### Parameters
- `url` : (required) the original URL

#### Responses
- `201 Created`: The URL is successfully created and the location of the new resource is returned in the `Location` header.
- `400 Bad Request`: The provided url or short url is not valid.


Example Request:
HTTP/1.1
Content-Type: application/json

```json
{
    "url": "https://www.example.com"
}
```

Example Response:
HTTP/1.1 201 Created
Content-Type: application/json
Location: /url/2
```
{
    "id": 2,
    "url": "https://www.example.com",
    "createdDate": "2022/01/01 12:00:00",
    "shortUrl": "https://localhost/2"
}
```

### GET `/url/all`

Retrieves all the URLs.

#### Responses
- `200 OK`: A list of all the URLs is returned in the response body.

Example Request:

HTTP/1.1
Content-Type: application/json


Example Response:
HTTP/1.1 200 OK
Content-Type: application/json


```json
[
    {
        "id": 1,
        "url": "https://www.example.com",
        "createdDate": "2022/01/01 12:00:00",
        "shortUrl": "https://localhost/1"
    },
    {
        "id": 2,
        "url": "https://www.example2.com",
        "createdDate": "2022/01/02 12:00:00",
        "shortUrl": "https://localhost/2"
    }
]

```

### GET `/urls`

Retrieves all the URLs.

#### Responses
- `200 OK`: A an HTML page with a list of URLs and a form to submit new URLS.

e.g.

![UI](./UI.png)



## Test Coverage

![Test Coverage](./TestCoverage.png)



## [URL Shortening Design](https://github.com/mehkey/system-design/tree/main/designs/URLShortner)

![URL Shortening Design](https://raw.githubusercontent.com/mehkey/system-design/main/designs/URLShortner/Untitled6.png)



## Functional Requirements:
- A user should provide a URL and receive a shoreded url
- A user should be redirected to the original URL when going to the shoretened URL
- Timelimit on the short? URL valid for a configurable amount of time


## Non-Functional Requirements:
- Scalability
- Performance (Max Latency e.g. 100 MS with 99.999)
and Elasticity
- Availability


## Kubernetes Yaml:


```yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: URLShortening-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: URLShortening
  template:
    metadata:
      labels:
        app: URLShortening
    spec:
      containers:
      - name: URLShortening
        image: URLShortening:latest
        ports:
        - containerPort: 8080
        env:
        - name: JAVA_OPTS
          value: "-Dspring.profiles.active=prod"
---
apiVersion: v1
kind: Service
metadata:
  name: URLShortening-service
spec:
  selector:
    app: URLShortening
  ports:
  - name: http
    port: 80
    targetPort: 8080
  type: ClusterIP
---
apiVersion: v1
kind: Service
metadata:
  name: URLShortening-external-service
spec:
  selector:
    app: URLShortening
  ports:
  - name: http
    port: 80
    targetPort: 8080
  type: LoadBalancer


```
