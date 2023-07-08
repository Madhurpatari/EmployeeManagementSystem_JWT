## Employee Management System (EMS)

The Employee Management System (EMS) is a web application that allows you to manage employee information and perform CRUD (Create, Read, Update, Delete) operations on employee records. It provides RESTful APIs for interacting with the system.

### Features

- User authentication using JWT (JSON Web Tokens)
- Employee CRUD operations
- One-to-one relationship between employees and companies
- Integration with a MySQL database

### Technologies Used

- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Hibernate ORM (Object-Relational Mapping)
- MySQL
- Maven

### Getting Started

#### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL database
- Postman (or any REST API client) for testing the APIs

#### Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/employee-management-system.git
```
2. Configure the MySQL database by updating the `application.properties` file with your database credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
```
3. Build the project using Maven:
```bash
mvn clean install
```
4. Run the application:
```bash
java -jar target/employee-management-system.jar
```
5. The application will start running at http://localhost:8080.

### API Documentation
#### Authentication
To authenticate and obtain a JWT token, make a POST request to /auth/login with the following payload:
```json
{
  "username": "your_username",
  "password": "your_password"
}
```

The API will respond with a JWT token that you can use for subsequent requests by including it in the Authorization header as a Bearer token.

#### Employee APIs
- GET /employees - Retrieve a list of all employees.
- GET /employees/{id} - Retrieve an employee by ID.
- POST /employees - Create a new employee.
- PUT /employees/{id} - Update an existing employee.
- DELETE /employees/{id} - Delete an employee by ID.

Refer to the [API documentation](https://documenter.getpostman.com/view/26741522/2s93zH1eJ3) or Postman collection for more details on request payloads, response formats, and authentication requirements.

### Contribution
Contributions to the Employee Management System project are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.