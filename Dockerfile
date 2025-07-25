# Step 1: Build the Spring Boot app using Maven and Java 17
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run the built jar using JDK 17
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/content_management_system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
