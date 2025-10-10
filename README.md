## 📝 Journal App
A **Spring Boot–based Journal Entry Management System** designed to help users record daily entries, analyze emotional sentiment, and receive **weekly sentiment summaries via email**.
This project showcases clean **backend architecture using Spring Boot (MVC pattern)** and multiple integrations like **MongoDB, Redis, Kafka, and Cloud services**.

<br>

## 🚀 Features
✅ **User Authentication & Authorization** – Secure login, signup, and password recovery with Spring Security  
✅ **Sentiment Analysis Summary** – Automatic email of the week’s dominant mood/sentiment  
✅ **CRUD Journal Management** – Create, update, delete, and view journal entries  
✅ **Caching with Redis** – Improves API response time using Redis Cloud  
✅ **Event Streaming with Kafka** – Manages asynchronous event handling for scalability  
✅ **Environment Profiles** – Separate configurations for development and production  
✅ **Logging & Monitoring** – Centralized log management and quality checks with SonarQube  

<br>

## 🧰 Tech Stack
- ***`Language`*** : Java
- ***`Framework`*** : Spring Boot
- ***`Database`*** : MongoDB (Atlas)
- ***`Caching`*** : Redis Cloud
- ***`Event Streaming`*** : Apache Kafka (Confluent Cloud)
- ***`Security`*** : Spring Security, JWT
- ***`Testing`*** : JUnit5, Mockito
- ***`Scheduler`*** : Cron Scheduler
- ***`Code Quality`*** : SonarQube, SonarCloud
- ***`Build Tool`*** : Maven
- ***`Version Control`*** : Git + GitHub

<br>

## 📂 Project Structure
```arduino
com.gyarsilalsolanki011.JournalApp/
├── api/                    # Handles external API responses or third-party integrations
│   └── response/           # Response models for APIs (e.g., WeatherResponse)
├── cache/                  # Cache configuration and management logic (Redis integration)
├── config/                 # Application configuration (Kafka, Redis, Security, etc.)
├── constants/              # Application-wide constant values
├── controller/             # REST controllers handling HTTP requests and responses
├── entity/                 # MongoDB entity classes (mapped to collections)
├── enums/                  # Enum definitions (roles, status types, etc.)
├── filter/                 # Request/response filters (e.g., JWT authentication filter)
├── model/                  # DTOs and model classes for request/response payloads
├── repository/             # Data access layer using MongoDB repositories
├── schedulers/             # Scheduled tasks (e.g., weekly sentiment email jobs)
├── service/                # Core business logic and service layer implementations
├── utils/                  # Utility/helper classes (e.g., SentimentAnalyzer, common functions)
└── JournalApplication.java # Main Spring Boot application entry point
```

<br>

## 🧠 Architecture Overview
The app follows the MVC architecture, ensuring clean separation of concerns and scalability.
```markdown
Controller  →  Service  →  Repository  →  MongoDB
      |          |              |
      ↓          ↓              ↓
 Redis Cache   Kafka Events   Mongo Transactions
```

<br>

## 🧪 Testing & Quality Assurance
 `Mockito` – Unit testing and argument provider  
 `JUnit 5` – Integration testing  
 `SonarQube` – Static code analysis  
 `Profiles` – Separate configs for Production & Development environments  

<br>

## 📬 Weekly Sentiment Mail
Every week, the system analyzes user journal entries, detects emotional tone, and automatically sends an email with the most frequent sentiment — providing personal insight into the user’s week.

<br>

## 💡 Future Enhancements
1. Add AI-powered sentiment classification
2. Integrate notification service (SMS/Push)
3. Deploy microservices version with Docker and Kubernetes

<br>

## 📜 License
This project is open source and available under the [`MIT License`](LICENSE).
