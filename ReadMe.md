# Test Automation Framework Documentation

## Overview

This project is a Java-based automated testing framework built to support clean test structure, easy maintenance, and scalability.  
It provides a solid foundation for writing functional and integration tests while keeping the codebase organized and easy to extend.

### Suggested Improvements

To enhance readability, maintainability, and test robustness, the following libraries could be added:

- **AssertJ** – offers a fluent and human-readable assertion style, making test failures easier to understand.
- **Owner** – a lightweight library for managing configuration and environment variables, allowing convenient switching between environments.
- **Lombok** – reduces boilerplate code (getters, setters, constructors, builders), helping keep test code cleaner and more readable.

Integrating these libraries would bring better structure, flexibility, and clarity to the project.

---

## Test Structure

The framework includes automated tests organized into three main suites, each serving a specific purpose within the testing process:

### 1. **Priority 0 – Quality Gate Tests**
These are the highest-priority tests, focused on critical functionality.  
They are designed to run on every pull request to ensure that new changes do not break core features.  
This suite can be integrated into the CI pipeline as a **Quality Gate**, preventing unstable code from being merged.

### 2. **Priority 1 – Health Check Tests**
These tests provide a quick validation of the overall system stability.  
They can be executed periodically or after each deployment to verify that the main features and services are operational.

### 3. **Full Regression Suite**
This suite includes comprehensive end-to-end coverage of all major test scenarios.  
It is typically executed on schedule (e.g., nightly or weekly) or before major releases to ensure full system integrity.

Each suite can be triggered independently, depending on the testing goal or stage of the delivery pipeline.

---

## How to Run Project Tests

To run project tests, use the command below and specify the required parameters:

- **Environment** – defines which environment the tests will run against (e.g., `stage`, `prod`)
- **TestSuite** – specifies which suite should be executed (`p0`, `p1`, or `fullRegression`)

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/fullRegression.xml -Denv=prod
```

Generate and run report
```bash
allure serve
```
## Framework Design Principles

The project follows common best practices for building a maintainable and scalable automated test framework.  
Key techniques and architectural elements used in the project include:

- **Layered structure** – test logic is separated from low-level API calls and utilities, making the code easier to maintain.
- **Test grouping** – tests are organized into dedicated suites (`Priority 0`, `Priority 1`, `Full Regression`) to support different execution strategies.
- **Simple DataProvider example** – demonstrates how to parameterize tests and execute the same scenario with multiple input values.
- **DTO layer (Data Transfer Objects)** – used to store and map request/response models, keeping serialization and object representation clean.
- **Utility classes** – contain helper methods and shared reusable logic to avoid duplication in tests.
- **Controller layer** – encapsulates endpoint interaction, providing clean methods for sending requests and receiving responses.

This architecture keeps the framework modular, readable, and easy to extend.

## Bugs and Observations

During analysis and implementation of tests for the provided REST controller, several critical architectural and functional issues were identified:

- **Incorrect HTTP methods (example)**
    - The controller uses `GET` requests to create entities (for example, creating a player with query parameters).
    - According to REST principles, creation operations must use `POST` with a request body, and typically include authentication.
    - Using `GET` for creation breaks REST conventions and may lead to unintended caching or proxy issues.

- **Incorrect usage of query parameters**
    - Critical data (such as player creation data) is passed as query parameters.
    - In REST, such operations should be performed using a JSON body in a `POST` request to ensure proper data structure, validation, and security.

- **Invalid HTTP status codes**
    - Responses do not follow standard HTTP semantics.
    - For example:
        - Creating a new resource should return `201 Created`
    - Many endpoints declared in Swagger return success codes that do not match their actual behavior or intended REST specification.

These issues should be addressed in the backend implementation, since incorrect HTTP methods and response codes may cause instability, security risks, or incompatibility with REST clients and automated testing tools.

**API works unstable. Ex.(createPlayer stopped working for me). But, I've created many players before.**





