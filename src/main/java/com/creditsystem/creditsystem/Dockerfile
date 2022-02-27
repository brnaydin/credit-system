FROM openjdk:11-jdk-alpine

MAINTAINER Baran AYDIN <brnaydin@outlook.com>
EXPOSE 8091
ADD target/credit-system-0.0.1-SNAPSHOT.jar credit-system.jar

ENTRYPOINT ["java","-jar","credit-system.jar"]

## Dockerizing the app
#
# Create a Spring Boot Application
# Create Dockerfile
# Build executable jar file - mvn clean package
# Build Docker image - docker build -t credit-system:v1 .
# Run Docker container using the image built - docker run --name credit-system -p 8080:8080 credit-system:v1
# Test