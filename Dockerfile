FROM maven:3.6.1-jdk-11-slim as builder

WORKDIR /app

COPY src /app/src

COPY pom.xml /app/

RUN mvn clean install

FROM openjdk:11.0.3-jdk-slim-stretch

WORKDIR /app

COPY --from=builder /app/target/cloud-sql-example-1.0.0.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]