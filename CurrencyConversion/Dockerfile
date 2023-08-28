# FROM amazoncorretto:17-alpine-jdk
# WORKDIR /app
# COPY ./target/*.jar spring-app.jar
# CMD [ "java", "-jar", "spring-app.jar" ]

# Stage 1: Build the Spring Boot application
FROM amazoncorretto:17 as build
WORKDIR /app
COPY . /app
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a runtime container
FROM amazoncorretto:17
WORKDIR /app
COPY --from=build /app/target/*.jar /app/your-app.jar
CMD ["java", "-jar", "your-app.jar"]