# Esports Championship API

[PT-BR](README.md) | [EN](README.en.md)

REST API for managing e-sports championships, including users, teams, matches, registrations, and rankings.

## Overview

The project follows a Clean Architecture-inspired organization:

- `core/`
  - `domain/`: business entities (`User`, `Team`, `Championship`, etc.)
  - `gateway/`: contracts (ports) for data/infra access
  - `usecases/`: business rules and use cases
- `infrastructure/`
  - `presentation/`: REST controllers
  - `gateway/`: implementations of `core` contracts
  - `persistence/`: MongoDB entities and repositories
  - `mappers/`: Domain <-> DTO <-> Entity conversion
  - `config/`: JWT security and OpenAPI
  - `exceptions/`: centralized error handling

## Current Stack

- Java 17
- Spring Boot 3.4.x
- Spring Web
- Spring Security (custom JWT with `java-jwt`)
- Spring Data MongoDB
- OpenAPI/Swagger (`springdoc`)
- Lombok
- Maven

## Folder Structure

```text
src/main/java/fan/esports/championship/Esports/Championship
├── core
│   ├── domain
│   ├── enums
│   ├── gateway
│   └── usecases
└── infrastructure
    ├── beans
    ├── config
    ├── dtos
    ├── exceptions
    ├── gateway
    ├── mappers
    ├── persistence
    ├── presentation
    └── token
```

## Prerequisites

- JDK 17
- Maven 3.9+ (or use `./mvnw`)
- MongoDB available

## Configuration

The following variables are used in `src/main/resources/application.yml`:

- `URI_MONGO`
- `MY_SECRET_KEY`

Example for Linux/zsh:

```zsh
export URI_MONGO="mongodb://localhost:27017/esports"
export MY_SECRET_KEY="replace-with-a-secure-key"
```

## Running the Project

```zsh
./mvnw clean spring-boot:run
```

To generate the artifact:

```zsh
./mvnw clean package
java -jar target/Esports-Championship-0.0.1-SNAPSHOT.jar
```

## API Documentation

With the application running:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Authentication

The API uses JWT in the header:

```http
Authorization: Bearer <token>
```

Currently configured public routes:

- `POST /api/v1/users/create`
- `POST /api/v1/users/login`
- `GET /v3/api-docs/**`
- `GET /swagger-ui/**`

## Main Endpoints (current state)

### Users

- `POST /api/v1/users/create`
- `POST /api/v1/users/login`
- `GET /api/v1/users/findAll`
- `GET /api/v1/users/getById/{id}`
- `GET /api/v1/users/getByNickname/{nickname}`
- `PUT /api/v1/users/update/{id}`
- `PATCH /api/v1/users/promote/{id}`
- `DELETE /api/v1/users/delete/{id}`

### Championships

- `POST /api/v1/championship/create`
- `GET /api/v1/championship/findAll`
- `GET /api/v1/championship/findById/{id}`
- `GET /api/v1/championship/findAvailable`
- `GET /api/v1/championship/findExpired`
- `GET /api/v1/championship/findByGameName?gameName=...`
- `GET /api/v1/championship/findByType?type=...`
- `GET /api/v1/championship/findByFormat?format=...`
- `PUT /api/v1/championship/update/{id}`
- `DELETE /api/v1/championship/delete/{id}`

### Teams

- `POST /api/v1/teams/create`
- `GET /api/v1/teams/findAll`
- `GET /api/v1/teams/findById/{id}`
- `PUT /api/v1/teams/update/{id}`
- `GET /api/v1/teams/getScheduledMatches/{teamId}`

### Matches

- `POST /api/v1/matches/create`
- `GET /api/v1/matches/findAll`
- `GET /api/v1/matches/findById/{id}`
- `PUT /api/v1/matches/update/{id}`
- `DELETE /api/v1/matches/delete/{id}`

## Tests

There is currently a Spring context test under `src/test/java`.

```zsh
./mvnw test
```

## Recommended Technologies for Evolution

- **Redis (recommended for cache):** useful for frequent read operations such as championship listings, rankings, and id-based queries.
- **Bean Validation:** add `spring-boot-starter-validation` to validate payloads with `@Valid`.
- **Testcontainers:** improves reliability of integration tests with MongoDB/Redis.
- **Spring Actuator + Micrometer:** observability (health checks, metrics, monitoring).

## Java Status

The project is already configured for **Java 17** in `pom.xml` (`<java.version>17</java.version>`).

## Suggested Roadmap

1. Standardize endpoints to REST style without verbs in paths.
2. Unify API error response format.
3. Remove `null` returns in gateways and use cases.
4. Increase unit and integration test coverage.
