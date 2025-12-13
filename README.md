# 🎓 University Management System — FAANG-Grade Backend Architecture

A production-inspired University Management System built to demonstrate enterprise backend architecture, classic design patterns, and systems-level thinking aligned with FAANG / Big Tech engineering standards.

This project intentionally goes beyond CRUD to showcase how real-world backend systems are designed, executed, and maintained at scale.

---

## 🚀 Key Highlights

- Enterprise-grade layered architecture
- Explicit end-to-end execution flow
- Strong design pattern usage (Factory, Strategy, Singleton, DAO)
- Clean Request → Service → Domain → Persistence pipeline
- CI/CD-ready structure
- Interview-ready documentation

---

## 🧱 Architecture Philosophy

This system follows principles used in large-scale backend systems:

- Thin, stateless controllers
- Rich service layer handling orchestration
- Pure domain models with no framework dependencies
- Strict isolation of persistence logic
- Explicit visibility into execution flow
- Externalized configuration and infrastructure

---

## 🏗️ High-Level System Architecture (Mermaid)

flowchart TB
    UI[Client / UI Layer (Web / CLI / API Consumer)]
    Controller[Controller Layer (Request Handling)]
    Service[Service Layer (Business Logic)]
    Domain[Domain Models (Student | Professor | Course | Enrollment)]
    Factory[Factory Pattern (Object Creation)]
    Strategy[Strategy Pattern (Business Rules)]
    Singleton[Singleton Pattern (Shared Resources)]
    DAO[DAO Layer (Data Access Objects)]
    DB[(Relational Database)]
    Config[Configuration Layer (Properties / Env)]
    CI[CI/CD Pipeline (.gitlab-ci.yml)]

    UI --> Controller
    Controller --> Service
    Service --> Factory
    Service --> Strategy
    Factory --> Domain
    Strategy --> Domain
    Service --> DAO
    DAO --> DB
    Config --> Service
    Config --> DAO
    Singleton --> Service
    Singleton --> DAO
    CI --> Controller
    CI --> Service
    CI --> DAO

---

## 🔄 End-to-End Execution Flow (Request Lifecycle)

sequenceDiagram
    participant User
    participant UI
    participant Controller
    participant Service
    participant Factory
    participant Strategy
    participant Domain
    participant DAO
    participant DB

    User->>UI: Perform Action (Enroll Student)
    UI->>Controller: HTTP / Command Request
    Controller->>Service: Validate & Delegate
    Service->>Factory: Create Domain Objects
    Factory->>Domain: Instantiate Models
    Service->>Strategy: Apply Business Rules
    Strategy->>Domain: Validate Constraints
    Domain-->>Strategy: Domain Result
    Strategy-->>Service: Approved / Rejected
    Service->>DAO: Persist / Query Data
    DAO->>DB: Execute SQL / Transaction
    DB-->>DAO: Result Set
    DAO-->>Service: Data Objects
    Service-->>Controller: Response DTO
    Controller-->>UI: Final Response
    UI-->>User: Output

---

## 📦 Layer-by-Layer Breakdown

### 1️⃣ Client / UI Layer
Entry point for all interactions. Supports REST, CLI, or UI. Contains no business logic.

### 2️⃣ Controller Layer
Handles routing, validation, and delegation. Stateless by design.

### 3️⃣ Service Layer (Core Business Logic)
Coordinates domain models, applies business rules, invokes persistence, and manages execution flow.

### 4️⃣ Domain Layer
Pure business entities with no framework dependencies. Represents real-world university concepts.

### 5️⃣ Design Patterns Used
- Factory Pattern for object creation
- Strategy Pattern for interchangeable business rules
- Singleton Pattern for shared resources
- DAO Pattern for persistence isolation

### 6️⃣ Persistence Layer
Encapsulates all database access. Prevents database logic from leaking into services.

### 7️⃣ Database Layer
Relational database accessed only through DAOs.

### 8️⃣ Configuration & Infrastructure
Environment-based configuration and CI/CD pipeline for production readiness.

---

## 🧩 Why This Project Matters

This repository demonstrates:
- Systems thinking
- Backend architecture design
- Design pattern mastery
- Execution pipelines
- Production-style engineering discipline

Highly relevant for Backend, Platform, and Infrastructure engineering roles.

---

## 📜 License
MIT
