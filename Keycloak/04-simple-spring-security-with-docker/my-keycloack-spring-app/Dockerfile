FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/my-boot-docker-sample.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]