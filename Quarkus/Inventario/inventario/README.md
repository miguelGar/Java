# Inventory

> Quarkus application RESTful API for an inventory platform.

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
- **Date Created**: 19/09/2024


---

## Technologies

This project was built with the following technologies:

- **Java**: Version 17
- **Quarkus**: Version 3.14.3
- **Orm-panache**: For database interaction.
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
   git clone https://github.com/miguelGar/Java/Quarkus/Inventario/inventario

2. Set up environment variables

    - All the configurations for the MySQL database are in the file: `application.properties`. Make shure you have installed MySQL Workbench

    - the property create the DB when you run the app

      > quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/inventario_db?createDatabaseIfNotExist=true

3. Build the project:

  ```shell script
  mvn clean
  ```

  ```shell script
  mvn compile
  ```

5. Run the application

  ```shell script
  ./mvnw compile quarkus:dev
  ```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080>.

6. The application can be packaged using

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

7. build an _über-jar_

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

8. packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

9. Native executable using:

```shell script
./mvnw package -Dnative
```

10. If you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/inventario-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.


## API Endpoints

http://localhost:8085/inventario-app/

Example:

- **GET:** /productos: Get products.
- **GET:** /productos/{id}: Get product by Id.
- **POST:** "": Add product.
    - Request body (JSON):
   ```bash
  {
        "descripcion": "Camisa",
        "precio": 300.0,
        "existencia": 13
  }
- **PUT:** /{id}: Update product by Id.
    - Request body (JSON):
  ```bash
  {
        "descripcion": "Tirantes",
        "precio": 150.0,
        "existencia": 13
  }
- **DELETE:** productos/{id} : Delete product by Id.

## Database

Database:
- **Tables:**
    - **products:** Stores product information.

## Contact

For any questions, feel free to reach out:

- **Email:** miguelgarciarob@gmail.com
- **GitHub:** https://github.com/miguelGar
- **LinkedIn:** Miguel Garcia
