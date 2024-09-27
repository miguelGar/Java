# Inventory

> Java  application for local interaction.

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
- **Date Created**: 26/09/2024


---

## Technologies

This project was built with the following technologies:

- **Java**: Version 17
- **Maven**: For dependency management (NO USE).

---

## Setup and Installation

### Prerequisites:
- **JDK**: Ensure you have JDK 17 or higher installed.
- **Maven**: Installed on your system.


### Steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/miguelGar/project/MundoPc

2. Set up environment variables

   - All the configurations for the MySQL database are in the file: <h5><strong><code>application.properties</code></strong></h5>. Make shure you have installed MySQL Workbench
   
   - the property create the DB when you run the app
    
      > spring.datasource.url=jdbc:mysql://localhost:3306/inventario_db?createDatabaseIfNotExist=true

3. Build the project:

   mvn clean install
   
5. Run the application

   just run locally in the main class mundoPc.java


## Contact

For any questions, feel free to reach out:

- **Email:** miguelgarciarob@gmail.com
- **GitHub:** https://github.com/miguelGar
- **LinkedIn:** Miguel Garcia
