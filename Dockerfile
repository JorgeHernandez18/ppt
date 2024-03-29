FROM maven:3.8.3-openjdk-17-slim as Build

WORKDIR /app

COPY pom.xml .

COPY src/ ./src/

RUN mvn package

FROM openjdk:17-oraclelinux8

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]

EXPOSE 8080
