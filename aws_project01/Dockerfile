FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app
VOLUME /tmp

COPY target/aws_project01-1.1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
