# Mark E-Commerce Spring Boot

Modern e-commerce platform built with Spring Cloud microservices architecture.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.0.3-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📋 Table of Contents

- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Services](#services)
- [Getting Started](#getting-started)
- [Docker Compose](#docker-compose)
- [Kubernetes Deployment](#kubernetes-deployment)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)
- [License](#license)

## 🏗️ Architecture

This project follows a **microservices architecture** pattern with the following components:

```
                         ┌─────────────────┐
                         │   API Gateway   │
                         │   (Port 8080)   │
                         └────────┬────────┘
                                  │
          ┌───────────────────────┼───────────────────────────┐
          │                       │                           │
          ▼                       ▼                           ▼
┌─────────────────┐      ┌─────────────────┐          ┌─────────────────┐
│  User Service   │      │ Product Service │          │  Order Service  │
│   (Port 8700)   │      │   (Port 8500)   │          │   (Port 8300)   │
└────────┬────────┘      └───────┬─────────┘          └────────┬────────┘
         │                       │                             │
         │                       │                             │
         └───────────────────────┼─────────────────────────────┘
                                 │
                    ┌────────────┴──────────┐
                    │   Service Discovery   │
                    │   (Eureka - 8761)     │
                    └───────────────────────┘
```

### Core Components

| Component | Port | Description |
|-----------|------|-------------|
| API Gateway | 8080 | Entry point for all client requests |
| Service Discovery | 8761 | Eureka server for service registration |
| Cloud Config | 9296 | Centralized configuration management |
| Zipkin | 9411 | Distributed tracing |
| User Service | 8700 | User management and authentication |
| Product Service | 8500 | Product catalog management |
| Order Service | 8300 | Order processing |
| Payment Service | 8400 | Payment processing |
| Shipping Service | 8600 | Shipping management |
| Favourite Service | 8800 | Customer favorites |
| Proxy Client | 8900 | Client proxy service |

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.3.3
- **Cloud**: Spring Cloud 2023.0.3
- **Java Version**: 17+
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Configuration**: Spring Cloud Config
- **Circuit Breaker**: Resilience4j
- **Observability**: Micrometer + Zipkin + Prometheus
- **API Documentation**: Springdoc OpenAPI
- **Testing**: TestContainers
- **Containerization**: Docker, Docker Compose
- **Orchestration**: Kubernetes

## 📦 Services

### Infrastructure Services

1. **Service Discovery** (`service-discovery/`)
   - Netflix Eureka Server
   - Service registration and discovery
   - Port: 8761

2. **Cloud Config Server** (`cloud-config/`)
   - Centralized configuration management
   - Port: 9296

3. **API Gateway** (`api-gateway/`)
   - Request routing and filtering
   - Authentication and authorization
   - Rate limiting
   - Port: 8080

### Business Services

4. **User Service** (`user-service/`)
   - User authentication and authorization
   - User profile management
   - Address management
   - Credentials management
   - Port: 8700

5. **Product Service** (`product-service/`)
   - Product catalog management
   - Category management
   - Product search and filtering

6. **Order Service** (`order-service/`)
   - Order processing
   - Order history
   - Order status tracking

7. **Payment Service** (`payment-service/`)
   - Payment processing
   - Payment methods management

8. **Shipping Service** (`shipping-service/`)
   - Shipping information
   - Delivery tracking

9. **Favourite Service** (`favourite-service/`)
   - Customer favorites/wishlists
   - Product preferences

10. **Proxy Client** (`proxy-client/`)
    - Client proxy service
    - Inter-service communication

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- Docker (optional)
- Kubernetes (optional, for K8s deployment)

### Build the Project

```bash
# Build the parent project
./mvnw clean install -DskipTests

# Or build individual services
cd <service-directory>
./mvnw clean package -DskipTests
```

### Run Locally

Each service can be run independently:

```bash
# Service Discovery
cd service-discovery
./mvnw spring-boot:run

# Cloud Config
cd cloud-config
./mvnw spring-boot:run

# API Gateway
cd api-gateway
./mvnw spring-boot:run

# Other services...
```

## 🐳 Docker Compose

Start all services using Docker Compose:

```bash
# Build and start all services
docker-compose up --build

# Or start in detached mode
docker-compose up -d
```

### Service Startup Order

The services start in the following order:

1. **zipkin** - Distributed tracing server
2. **cloud-config** - Configuration server
3. **service-discovery** - Eureka service registry
4. **proxy-client** - Client proxy service
5. **user-service** - User management
6. **product-service** - Product catalog
7. **order-service** - Order management
8. **payment-service** - Payment processing
9. **shipping-service** - Shipping management
10. **favourite-service** - Customer favorites
11. **api-gateway** - API entry point

### Accessing Services

| Service | URL |
|---------|-----|
| API Gateway | http://localhost:8080 |
| Service Discovery | http://localhost:8761 |
| Cloud Config | http://localhost:9296 |
| Zipkin | http://localhost:9411 |
| User Service | http://localhost:8700 |
| Product Service | http://localhost:8500 |
| Order Service | http://localhost:8300 |
| Payment Service | http://localhost:8400 |
| Shipping Service | http://localhost:8600 |
| Favourite Service | http://localhost:8800 |

## ☸️ Kubernetes Deployment

Deploy to Kubernetes using the provided manifests:

```bash
# Apply all Kubernetes manifests
kubectl apply -f k8s/
```

### Kubernetes Services

The following services are configured for Kubernetes deployment:

- `api-gateway/`
- `cloud-config/`
- `service-discovery/`
- `user-service/`
- `product-service/`
- `order-service/`
- `payment-service/`
- `shipping-service/`
- `favourite-service/`
- `proxy-client/`
- `zipkin/`

## 📚 API Documentation

Each service provides OpenAPI/Swagger documentation:

- **API Gateway**: http://localhost:8080/swagger-ui.html
- **User Service**: http://localhost:8700/swagger-ui.html
- **Product Service**: http://localhost:8500/swagger-ui.html
- And more...

## 📂 Project Structure

```
mark-ecommerce-spring-boot/
├── api-gateway/              # API Gateway service
├── cloud-config/             # Cloud Config Server
├── service-discovery/        # Eureka Service Registry
├── user-service/             # User management
├── product-service/          # Product catalog
├── order-service/           # Order processing
├── payment-service/          # Payment processing
├── shipping-service/         # Shipping management
├── favourite-service/        # Customer favorites
├── proxy-client/            # Client proxy
├── api-requests/           # HTTP client requests
├── k8s/                    # Kubernetes manifests
├── docker-compose.yml        # Docker Compose configuration
├── pom.xml                  # Parent POM
└── README.md                # This file
```

## 🔧 Configuration

### Environment Variables

Common environment variables used across services:

```bash
SPRING_PROFILES_ACTIVE=dev
EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://service-discovery:8761/eureka/
SPRING_CONFIG_IMPORT=optional:configserver:http://cloud-config:9296
MANAGEMENT_ZIPKIN_TRACING_ENDPOINT=http://zipkin:9411/api/v2/spans
```

### Application Properties

Each service can be configured via properties files in `src/main/resources/application.yml`.

## 🧪 Testing

Run tests using Maven:

```bash
# Run all tests
./mvnw test

# Run tests with coverage
./mvnw test jacoco:report
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

---

Built with ❤️ using Spring Cloud Microservices

