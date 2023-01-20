FROM maven:3.6.3-openjdk-17-slim AS builder-server

WORKDIR /usr/src/demo
COPY ./pom.xml .
RUN mvn -B dependency:go-offline

COPY . .
RUN mvn -B package

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=builder-server /usr/src/demo/target/demo-0.0.1-SNAPSHOT.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]