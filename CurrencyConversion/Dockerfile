# FROM amazoncorretto:17-alpine-jdk
# WORKDIR /app
# COPY ./target/*.jar spring-app.jar
# CMD [ "java", "-jar", "spring-app.jar" ]

# Stage 1: Build the Spring Boot application
FROM openjdk:17 AS build
WORKDIR /app
COPY . /app
RUN ./mvnw clean package

# Stage 2: Create a runtime container
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/your-app.jar /app/your-app.jar
CMD ["java", "-jar", "your-app.jar"]
