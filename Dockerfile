FROM openjdk:11
EXPOSE 8090
ADD target/SearchMicroservice-0.0.1-SNAPSHOT SearchMicroservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/SearchMicroservice-0.0.1-SNAPSHOT.jar"]
