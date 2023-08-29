# ConCurrency Server 💱💹

# **Service Functionalities** 💼

- A Backend Rest API designed using MVC Design Architecture. 🏗️
- Uses Feign Client to communicate with external currency conversion API. 📡
- Provides currency conversion services. 💱
- Allows comparison of conversion rates between different currencies. 🔄
- Retrieves all available currencies and their conversion rates. 🌐
- Uses Redis Server for caching responses to improve performance. 🚀
- Validates currency codes using my own annotations. ✔️
- Error and Exception handling. 🛠️
- Integration tests ensure the correctness and reliability of the service. 🧪
- Unit tests for individual components to ensure their correct behavior. 🧪
- Health check endpoint to monitor the status of the application. 🩺
- Continuous Integration/Continuous Deployment (CI/CD) with Jenkins to automate the deployment process. 🔄


```
.
├── CurrencyConversion
│   ├── Dockerfile
│   ├── docker-compose.yml
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── currencyconversion
│   │   │   │               ├── CurrencyConversionApplication.java
│   │   │   │               ├── checkHealth
│   │   │   │               │   └── MemoryHealthIndicator.java
│   │   │   │               ├── client
│   │   │   │               │   └── CurrencyConversionClient.java
│   │   │   │               ├── controller
│   │   │   │               │   └── CurrencyConversionController.java
│   │   │   │               ├── dto
│   │   │   │               │   ├── ConversionDto.java
│   │   │   │               │   ├── CurrencyResponseDto.java
│   │   │   │               │   ├── ErrorDto.java
│   │   │   │               │   └── RateDto.java
│   │   │   │               ├── exception
│   │   │   │               │   ├── ApiError.java
│   │   │   │               │   ├── CustomException.java
│   │   │   │               │   └── CustomExceptionHandler.java
│   │   │   │               ├── service
│   │   │   │               │   ├── CurrencyConversionService.java
│   │   │   │               │   └── impl
│   │   │   │               │       └── CurrencyConversionServiceImpl.java
│   │   │   │               ├── util
│   │   │   │               │   └── Currency.java
│   │   │   │               └── validation
│   │   │   │                   ├── CurrencyValidator.java
│   │   │   │                   └── annotation
│   │   │   │                       └── ValidCurrency.java
│   │   │   └── resources
│   │   │       └── application.properties
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── currencyconversion
│   │                       ├── CurrencyConversionApplicationTests.java
│   │                       ├── controller
│   │                       │   └── CurrencyConversionControllerTest.java
│   │                       └── service
│   │                           └── CurrencyConversionServiceTest.java
```

# **Tech Stack ⚡**

- Programming Language: Java 17
- Backend Framework: Spring Boot v3.1.2
- API Documentation: Swagger via OpenApi 3.0
- Containerization: Docker
- Cloud: AWS, Railway
- CI/CD: Jenkins
- Other Frameworks: Spring Cloud OpenFeign, Spring Data Redis, Spring Cache

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

[![Maven](https://badgen.net/badge/icon/maven?icon=maven&label)](https://https://maven.apache.org/)

![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Railway](https://img.shields.io/badge/Railway-003545?style=for-the-badge&logo=railway&logoColor=white)
![AWS](https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)


# API Documentation 📝 via [|Swagger|](http://ec2-3-144-40-233.us-east-2.compute.amazonaws.com:8000/swagger-ui/index.html#/)
