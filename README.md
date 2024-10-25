# API Gateway

The API Gateway acts as a single entry point for client requests and routes them to appropriate backend services.

## Getting Started

The API Gateway is configured to work with Eureka and forwards requests to the services registered with Eureka.

### Prerequisites

- Java 17
- Maven
- Docker (optional)

### Local Setup Without Docker

1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    cd api-gateway
    ```

2. **Configure application properties**: Update `src/main/resources/application.properties`:
    ```properties
    spring.application.name=api-gateway
    server.port=8765
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
    spring.cloud.gateway.discovery.locator.enabled=true
    ```

3. **Build the application**:
    ```bash
    mvn clean install
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

### Local Setup With Docker

1. **Build the Docker image**:
    ```bash
    docker build -t api-gateway .
    ```

2. **Run the Docker container**:
    ```bash
    docker run -p 8765:8765 api-gateway
    ```

Your API Gateway should now be available at `http://localhost:8765`.
