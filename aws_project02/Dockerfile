FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app
VOLUME /tmp

COPY target/aws_project02-1.4.0.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","app.jar"]
