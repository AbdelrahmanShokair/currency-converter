FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY home/ec2-user/currency-converter/CurrencyConversion/target/*.jar spring-app.jar
CMD [ "java", "-jar", "spring-app.jar" ]