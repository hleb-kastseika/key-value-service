# key-value-service
Standalone key-value REST service using Java, Spring Boot, Redis and Docker with Docker Compose.
Due to dockerized Redis the data are persisted permanently. You can check it with next steps:
1) start up service with ```docker-compose up```
2) save something using REST API
3) stop service using docker-compose
4) re-start service
5) try to get saved value using REST API

### Requirements:
- Java 11 or higher
- Maven
- Docker
- Docker Compose

### How to build and to run:
```
mvn clean package
docker-compose build
docker-compose up
```

### How to test
After startup of both Docker containers you are able to call REST API.
There are two available methods:
```
POST /{key}/{value}
GET /{key}
```

To put new value to the storage use POST method:
```
~$ curl -X POST 0.0.0.0:8080/newkey/testvalue
```
To retrieve the value from the storage use GET method:
```
~$ curl -i 0.0.0.0:8080/newkey
HTTP/1.1 200 OK
Date: Sat, 09 Apr 2022 17:32:34 GMT
Content-length: 6

newkey
```
If you try to get not existing value you will get 404 response:
```
~$ curl -i 0.0.0.0:8080/invalidkey
HTTP/1.1 404 Not Found
Date: Sat, 09 Apr 2022 17:36:12 GMT
Content-length: 6

{"timestamp":"2022-04-09T17:36:12.531+00:00","status":404,"error":"Not Found","path":"/invalidkey"}
```