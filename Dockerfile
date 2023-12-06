FROM openjdk:17-jdk-alpine
COPY target/MSTxFleet-DBS-Redis-0.0.1-SNAPSHOT.jar MSTxFleet-DBS-Redis.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/MSTxFleet-DBS-Redis.jar"]