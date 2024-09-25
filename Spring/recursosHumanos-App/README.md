# Inventory

> Java Spring application RESTful API for an Admin Human reources platform.

## Table of Contents

- [Overview](#overview)
- [Technologies](#technologies)
- [Setup and Installation](#setup-and-installation)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contact](#contact)

---

## Overview


- **Version**: `1.0.0`
- **Author**: Miguel García Pérez
- **Date Created**: 25/09/2024


---

## Technologies

This project was built with the following technologies:

- **Java**: Version 17
- **Spring Boot**: Version 3.3.3
- **Spring Data JPA**: For database interaction.
- **Maven**: For dependency management.
- **MySQL**: Database used.

---

## Setup and Installation

### Prerequisites:
- **JDK**: Ensure you have JDK 17 or higher installed.
- **Maven**: Installed on your system.
- **Database**: MySQL database, ensure it is installed and running.

### Steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/miguelGar/recursosHumanos-App

2. Set up environment variables

   - All the configurations for the MySQL database are in the file: <h5><strong><code>application.properties</code></strong></h5>. Make shure you have installed MySQL Workbench
   
   - the property create the DB when you run the app
    
      > spring.datasource.url=jdbc:mysql://localhost:3306/inventario_db?createDatabaseIfNotExist=true

3. Build the project:

   mvn clean install
   
5. Run the application

   mvn spring-boot:run

## API Endpoints

http://localhost:8080/rhApp

Example:
- **GET:** /empleados: Get products.
- **GET:** /empleados/{id}: Get product by Id.
- **POST:** /empleados: Add product.
   - Request body (JSON):
  ```bash
  {
        "nombre": "Carlitos",
        "departamento": "finanzas",
        "sueldo": 1000.0
  }
- **PUT:** /empleados/{id}: Update product by Id.
   - Request body (JSON):
    ```bash
   {
        "nombre": "Carlitos Juan",
        "departamento": "finanzas",
        "sueldo": 1200.0
  }
- **DELETE:** /empleados/{id} : Delete product by Id.

## Database

Database:
- **Tables:**
  - **empleado:** Empleado information.

## Contact

For any questions, feel free to reach out:

- **Email:** miguelgarciarob@gmail.com
- **GitHub:** https://github.com/miguelGar
- **LinkedIn:** Miguel Garcia
