# syntax=docker/dockerfile:1
FROM kady/jdk8:v1
#FROM openjdk
WORKDIR /app

COPY target/JMVND-0.0.1-SNAPSHOT.jar ./
EXPOSE 8080
CMD ["java", "-jar","JMVND-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]
