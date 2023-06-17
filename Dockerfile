FROM openjdk:8
EXPOSE 8080
ADD target/docker-practice.jar docker-practice.jar
ENTRYPOINT ["java","-jar","/docker-practice.jar"]