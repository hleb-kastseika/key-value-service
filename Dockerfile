FROM alpine:latest

RUN apk --update add openjdk11-jre

COPY target/key-value-service-1.0.jar key-value-service-1.0.jar

EXPOSE 8080

CMD java -jar key-value-service-1.0.jar