FROM openjdk:17
LABEL maintainer = "TrickAndTrack"
ADD target/Movie_RatingProject-0.0.1-SNAPSHOT.jar Movie_RatingProject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Movie_RatingProject-0.0.1-SNAPSHOT.jar"]