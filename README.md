# Spring-Tutorial

This is a sample project that uses Spring Boot and RestTemplate to consume third-party APIs. This project aims to serve as an example of how to create an application that consumes web services using Spring Boot.

## Project Structure

The project is structured as follows:


- `src/main/java`: Contains the application code.
- `src/main/resources`: Contains configuration files.
- `src/test/java`: Contains unit tests for the application.


## Model Classes
The model classes are located in the AISS.restClient.model package. They are created using Plain Old Java Objects (POJOs) made whit [jsonschema2pojo](https://www.jsonschema2pojo.org/) and represent the data structures used by the APIs being consumed.

- `Users package`: Represents a user object returned by the Regres API.
- `Commits package`: Represents a commmit object returned by the Github API.

## Using the Project

This project uses two third-party public APIs to demonstrate how to consume web services in a Spring Boot application:

- Regres: An API that simulates an authentication server and allows testing login requests.
- GitHub API: The public API of GitHub that allows accessing information about users, repositories, and more.

To use this project, follow these steps:

1. Clone the repository.
2. Provide a valid GitHub token in the `your_token.txt` file located in `src/test/java/AISS/restClient/service/`.
3. Run the tests classes to see the API consumption output.


## Notes

This project is just an example, and it is not expected to be implemented in production. The main purpose is to demonstrate how to consume web services using Spring Boot and RestTemplate.
