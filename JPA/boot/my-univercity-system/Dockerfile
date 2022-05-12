FROM openjdk:8

EXPOSE 8080

VOLUME /my-univercity-system
ADD target/my-univercity-system.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]