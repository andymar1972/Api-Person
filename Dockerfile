FROM openjdk:8-jdk-alpine
COPY "./target/person-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8001
ENTRYPOINT [ "java","-jar","app.jar" ]