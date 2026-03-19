# 💸 Safe-Transfer-API
**Secure Money Transfer Service with Spring Boot 4 & Java 21**

A robust Fintech API built for secure, atomic money transfers between accounts. This project focuses on data integrity, concurrency control, and clean layered architecture, developed during my professional transition in Ontario, Canada.

## 🚀 Key Features
- **Atomic Transactions**: Utilizes `@Transactional` to ensure a "all-or-nothing" approach, preventing partial updates during failures.
- **Concurrency Control**: Implements **Optimistic Locking** using JPA `@Version` and Java 21 to handle simultaneous transfer requests safely.
- **Audit Logging**: Every successful transfer is automatically recorded in a dedicated `Transaction` history table for auditing purposes.
- **Clean Architecture**: Follows a strict Layered Architecture (Controller-Service-Repository-Entity) for high maintainability.

## 🛠️ Tech Stack
- **Language**: Java 21 (LTS)
- **Framework**: Spring Boot 4.0.4
- **Build Tool**: Gradle
- **Database**: H2 (In-memory) for rapid testing and development
- **ORM**: Spring Data JPA
- **Testing**: Postman, JUnit 5

## 📂 Project Structure
- `com.fintech.safetransferapi.entity`: Domain models (`Account`, `Transaction`)
- `com.fintech.safetransferapi.service`: Business logic & transaction orchestration
- `com.fintech.safetransferapi.controller`: REST API endpoints with versioning (`v1`)
- `com.fintech.safetransferapi.dto`: Request/Response objects for secure data transfer

## 🚦 Getting Started
### Prerequisites
- JDK 21
- Any Java IDE (IntelliJ IDEA recommended)

### Running the Application
- **Standard**: `./gradlew bootRun` (Requires pre-configured `JAVA_HOME` for JDK 21)
- **Recommended**: Open this project in **IntelliJ IDEA**. The IDE will automatically detect the Gradle wrapper and JDK 21 settings.
- **Database**: Access the H2 Console at `http://localhost:8080/h2-console` after the application starts.
    - **JDBC URL**: `jdbc:h2:mem:testdb`
    - **User**: `sa` (No password)