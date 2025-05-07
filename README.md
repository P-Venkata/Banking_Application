
# Banking_Application

This is a Microservices-based banking application built with Spring Boot, using FeignClient for inter-service communication. All dependent services must be running to avoid errors.

# Key Features
UI : Contains the frontend code for the application.
Account Management: Create and delete user accounts.
Balance Enquiry: Check account balances.
Deposit and Withdrawal: Handle money transactions securely.
Service Communication: Uses FeignClient for RESTful interaction between services.

# Technology Stack

  Spring Boot – Java microservice framework
  Spring Cloud (Eureka) – Service discovery and registration
  Feign Client – For calling other microservices
  Spring Data JPA – ORM for database interaction
  MySQL – Persistent relational database
  
# Microservices in This Project

1. Eureka Server – Service registry
2. Create Account Service – For creating bank accounts
3. Delete Account Service – For deleting bank accounts
4. Balance Enquiry Service – For checking account balances
5. Deposit Service – For depositing money
6. Withdraw Service – For withdrawing money

# Access the Services on These Default Ports

- Eureka Server `http://localhost:8761`
- Create Account Service `http://localhost:8080`
- Delete Account Service `http://localhost:8081`
- Balance Enquiry Service `http://localhost:8083`
- Deposit Service `http://localhost:8084`
- Withdraw Service `http://localhost:8085`

# Notes

- All services must be up and registered with Eureka Server for Feign Clients to function correctly.
