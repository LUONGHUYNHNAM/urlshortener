# Sử dụng Eclipse Temurin JDK 21 làm base image
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy file JAR đã được build từ máy host vào container
COPY target/urlshortener-0.0.1-SNAPSHOT.jar app.jar

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
