# ConCurrency Server 🚀🚀

# **Service Functionalities** 🧠

- A Backend Rest API designed using MVC Design Architecture.
- Uses Feign Client to communicate with external currency conversion API.
- Provides currency conversion services.
- Allows comparison of conversion rates between different currencies.
- Retrieves all available currencies and their conversion rates.
- Uses Redis for caching responses to improve performance
- Validates currency codes using custom annotations.
- Error and Exception handling.
- Integration tests ensure the correctness and reliability of the service.

```
.
├── Dockerfile
├── README.md
├── docker-compose.yml
├── pom.xml
├── src
│ └── main
│ ├── java
│ │ └── com
│ │ └── example
│ │ └── currencyconversion
│ │ ├── CurrencyConversionApplication.java
│ │ ├── client
│ │ │ └── CurrencyConversionClient.java
│ │ ├── controller
│ │ │ └── CurrencyConversionController.java
│ │ ├── dto
│ │ │ ├── ConversionDto.java
│ │ │ ├── CurrencyDto.java
│ │ │ ├── CurrencyResponseDto.java
│ │ │ └── RateDto.java
│ │ ├── service
│ │ │ ├── CurrencyConversionService.java
│ │ │ └── impl
│ │ │ └── CurrencyConversionServiceImpl.java
│ │ └── util
│ │ └── Currency.java
│ └── resources
│ └── application.properties
```

# **Tech Stack ⚡**

- Programming Language: Java 17
- Backend Framework: Spring Boot v3.1.2
- API Documentation: Swagger via OpenApi 3.0
- Containerization: Docker
- Cloud: AWS
- Other Frameworks: Spring Cloud OpenFeign, Spring Data Redis, Spring Cache

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

[![Maven](https://badgen.net/badge/icon/maven?icon=maven&label)](https://https://maven.apache.org/)

![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![AWS](https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)

# API Documentation 📝 via [|Swagger|](http://ec2-3-144-40-233.us-east-2.compute.amazonaws.com:8000/swagger-ui/index.html#/)
