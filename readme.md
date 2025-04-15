# EventOrganizer

EventOrganizer is a collaborative event management platform built with Spring Boot. The application allows organizers to create, manage, and promote events, and lets users book their attendance and interact with event details. This project is designed for a team of two developers and includes features for user authentication, event creation, booking management, notifications, and more.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Running the Application](#running-the-application)

## Features

- **User Management:**  
  Registration, login, and role-based access control (Organizers, Users, Admin).

- **Event Management:**  
  Create, update, and delete events with details such as title, description, date, and location.

- **Booking System:**  
  Users can reserve seats for events, manage bookings, and simulate payment processes.

- **Collaborative Tools:**  
  Multiple organizers can collaborate in managing the same event.

- **Notifications:**  
  Email notifications and potential real-time updates using WebSocket integration.

- **API Documentation:**  
  Interactive API documentation using SpringDoc OpenAPI.

## Technologies

- **Backend Framework:** Spring Boot
- **Database:** MySQL (Dockerized)
- **Persistence:** Spring Data JPA
- **Security:** Spring Security
- **Templating:** Thymeleaf (optional)
- **Messaging:** RabbitMQ (optional)
- **Testing:** JUnit, Mockito
- **API Documentation:** SpringDoc OpenAPI

## Architecture

The project follows a modular monolithic architecture with clearly separated modules for users, events, and bookings. The API is designed to be RESTful, enabling easy integration with front-end frameworks like Angular, React, or Vue.js. The current setup includes basic messaging capabilities that can be expanded into asynchronous real-time notifications.

## Getting Started

### Prerequisites

- **Java 21** or higher installed
- **Maven** installed (or you can use the Spring Boot Maven wrapper)
- **Docker** installed (for running the MySQL container)
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Running the Application

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/eventorganizer.git
   cd eventorganizer
