FROM openjdk:11
COPY target/newSpringProject-0.0.1-SNAPSHOT.jar newSpringProject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","newSpringProject-0.0.1-SNAPSHOT.jar"]
