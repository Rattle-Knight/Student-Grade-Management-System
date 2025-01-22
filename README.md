# Student Grade Management System


## Overview
The Student Grade Management System is a web-based application designed to manage student records, grades, and associated modules. It features a multi-level architecture, with a JavaScript and CSS frontend and a Spring Boot backend powered by a H2 in-memory SQL database.

## Features
Backend: Spring Boot framework with Maven for dependency management and H2 database integration.
Data Flow: Implements CRUD operations and REST APIs to handle requests from the frontend, process them in the backend, and return data for display.
CI/CD Pipeline: Fully integrated with GitLab for continuous integration, ensuring quality and bug-free deployments.
Database Model
The system’s database is logically modeled with relations between entities such as Students, Grades, Modules, and Registration. These objects are instantiated within the Spring framework and mapped directly to the H2 database.

## Technical Highlights
CRUD Operations: Example endpoints include:
GET /students - Fetch student records.
POST /grades - Add a grade with dependency injection for related modules and students.
CI/CD Deployment: Automated builds and tests through a robust GitLab pipeline.
Challenges and Solutions
Mapping Errors: Resolved by redefining relationships and introducing proper variables for module references.
System Refactor: Reworked system architecture to correct aggregation issues between entities.
CI/CD Configuration: Fixed build configurations to align with updated project requirements.

## Retrospective
Successes: Improved understanding of Spring Boot, Maven, GitLab, and software engineering concepts.
Challenges: Faced and overcame significant refactoring and setup hurdles.
Future Development: Plans include adding authentication, login features, and extending registration capabilities.

## Conclusion
This project has been a valuable learning experience in building, deploying, and maintaining a full-stack application. It provided insights into real-world software engineering practices and reinforced key technical skills.
