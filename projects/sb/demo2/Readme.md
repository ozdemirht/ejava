# Introduction

Implements CRUD operations on a Customers table.

API Endpoints:

| Endpoints              | HTTP Verb | Operation                                   |
|------------------------|-----------|---------------------------------------------|
| /v1/customers          | POST      | Create                                      |
| /v1/customers          | GET       | List                                        |
| /v1/customers/{id}     | GET       | GET by id                                   |
| /v1/customers/{id}     | DELETE    | DELETE by id                                |
| /v1/customers?id={id}& | PUT       | Update name and/or last name of customer id |

# Prerequisites
1. Java 23
2. Maven 3.6.3
3. H2 in-memory Database

# How to run
| Linux | Windows              | Note                |
|-------|----------------------|---------------------|
 | mvn clean install | mvnw clean install   | Re-builds artifacts |
 | mvn spring-boot:run | mvnw spring-boot:run | Runs endpoint       |

# How to test
| Linux | Windows                                        | Note                |
|-------|------------------------------------------------|---------------------|
 | mvn clean test | mvnw clean test                                | Runs unit tests     |
 | mvn clean test | mvnw clean test -Dtest=CustomersControllerTest | Runs unit tests for CustomerControllerTest |

# TDD (JUnit 5 and Mockito)
Tests need to match to each layer. 
1. Controller
1. Service
1. Repository
1. Entity

# Project Directory Structure
The project directory structure is simple not following Hexagonal Architecture 
recommendations in the 
[article](https://medium.com/@bytecoders/hexagonal-architecture-in-spring-boot-the-ultimate-guide-for-spring-boot-f39ba348fd96)

# References
1. [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
1. [H2 in-memory Database](https://www.h2database.com/)
1. [JUnit 5](https://junit.org/junit5/)
1. [Mockito](https://site.mockito.org/)
1. [Hexagonal Architecture in Spring Boot — The Ultimate Guide for Spring Boot](https://medium.com/@bytecoders/hexagonal-architecture-in-spring-boot-the-ultimate-guide-for-spring-boot-f39ba348fd96)