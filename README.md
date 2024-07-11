# RentRead

RentRead is a RESTful API service for managing an online book rental system using Spring Boot and MySQL.

## Prerequisites

- Java 17
- Maven
- MySQL

## Installation

1. Clone the repository:

2. Build the project:

## Usage

1. Configure MySQL database settings in `application.properties`.
2. Run the application:

## API Endpoints

- POST /api/auth/register - Register a new user.
- POST /api/auth/login - Authenticate and receive a JWT token.
- GET /api/books - Retrieve all available books.
- POST /api/books - Create a new book (admin only).
- ...

## Configuration

Configure database connection and other settings in `src/main/resources/application.properties`.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
