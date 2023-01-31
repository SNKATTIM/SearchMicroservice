FROM openjdk:11
EXPOSE 8090
ADD target/*.jar search.jar
ENTRYPOINT ["java", "-jar","/search.jar"]
