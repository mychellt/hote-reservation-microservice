# Hotel Reservation Service

This is a simple hotel reservation system built using Java and Spring Boot.

## Features

- **Reservation Management**: Allows users to make, update, and cancel hotel reservations.
- **Integration with Messaging Service**: Utilizes RabbitMQ for asynchronous communication between microservices.
- **Multi-module Project Structure**: Organized into separate modules for better code organization and maintenance.

## Modules

1. **hotel-reservation-core**: Contains the core business logic and domain models for hotel reservations.
2. **hotel-reservation-persistence**: Handles persistence using JPA and provides repositories for accessing database entities.
3. **hotel-reservation-messaging**: Integrates with RabbitMQ for handling messaging-related tasks.
4. **hotel-reservation-http-resources**: Implements RESTful APIs using Spring Web for handling hotel reservation requests.
5. **hotel-reservation-domain**: module contains the core domain models and business logic for the hotel reservation system

## Setup

1. **Clone the Repository**:
<code>
git clone https://github.com/mychellt/hotel-reservation-service.git
</code>

## Configuration

- **Database Configuration**: Configure database settings in `application.properties` files located in each module.
- **Messaging Configuration**: Set up RabbitMQ connection properties in `application.properties` files in the messaging module.

## Dependencies

- Java 17
- Spring Boot 3.3.0
- Maven
- RabbitMQ
- PostgreSQL

