This project demonstrates securing RESTful APIs using JSON Web Tokens (JWT) for authentication in a Spring Boot application. It utilizes Spring Security, Spring Data JPA, and other essential Spring Boot components to build a robust backend that can register users, log them in, and secure API endpoints.

Features
User Registration: New users can register with a username and password.
User Authentication: Users can authenticate with their credentials to receive a JWT token.
JWT Token Generation: Generates a JWT token upon successful authentication.
Role-based Authorization: Secures endpoints based on user roles.
Custom User Details Service: Loads user details for authentication.
Password Encoding: Uses BCrypt for encoding user passwords.
Stateless Session Management: Ensures each request is stateless and secured by JWT.
Technologies Used
Java: JDK 17 or higher.
Spring Boot: 3.3.3
Spring Security: For authentication and authorization.
Spring Data JPA: For ORM and database interaction.
H2 Database: In-memory database for testing purposes.
JWT (JSON Web Tokens): For securely transmitting information.
Lombok: For reducing boilerplate code.
Maven: For dependency management.
Prerequisites
Java JDK 17 or higher installed.
Maven 3.6 or higher installed.
IDE (e.g., IntelliJ IDEA, Eclipse) configured for Spring Boot development.
Postman or a similar tool for testing RESTful APIs.

Testing with Postman
Register a User: Make a POST request to /api/register with a JSON body containing username and password.
Login User: Make a POST request to /api/login with the same credentials. You will receive a JWT token.
Access Secured Endpoints: Use the JWT token in the Authorization header to access secured endpoints.