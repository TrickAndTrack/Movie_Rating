FROM openjdk:17
LABEL maintainer = "TrickAndTrack"
ADD target/Hacker-News-API-0.0.1-SNAPSHOT.jar Hacker-News-API-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Hacker-News-API-0.0.1-SNAPSHOT.jar"]