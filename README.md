# CargoZen Backend 🚚

Backend service for **CargoZen**, an on-demand logistics and transportation platform with a planned AI-powered vehicle recommendation system.

CargoZen is being built with Java and Spring Boot using a layered backend architecture. The system is designed to handle customer registration, authentication, vehicle management, cargo details, bookings, and eventually AI-assisted vehicle recommendations.

---

## 🛠️ Technology Stack

### Backend

- **Java**
- **Spring Boot**
- **Spring Web** — REST API development
- **Spring Data JPA** — Database access and persistence
- **Hibernate** — ORM
- **Jakarta Bean Validation** — Request validation
- **Lombok** — Boilerplate reduction

### Database

- **MySQL**
- **MySQL Connector/J**
- **Spring Data JPA / Hibernate**

### AI

- **Spring AI** *(planned)*

---

## 📦 Dependencies

The current backend uses the following Spring Boot dependencies:

```text
Spring Web
MySQL Driver
Spring Data JPA
Lombok
Validation
```

---

## 🏗️ Architecture

CargoZen follows a layered architecture:

```text
                Client / Frontend
                       │
                       │ HTTP Request
                       ▼
              ┌─────────────────┐
              │   Controller    │
              │  REST Endpoints │
              └────────┬────────┘
                       │
                       ▼
              ┌─────────────────┐
              │     Service     │
              │ Business Logic  │
              └────────┬────────┘
                       │
                       ▼
              ┌─────────────────┐
              │   Repository    │
              │   Data Access   │
              └────────┬────────┘
                       │
                       ▼
              ┌─────────────────┐
              │      MySQL      │
              │    Database     │
              └─────────────────┘
```

The project separates responsibilities into:

```text
Controller
    ↓
DTO
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
MySQL
```

---

## 📁 Project Structure

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── tausif/
    │           └── CargoZen_Backend/
    │               │
    │               ├── controller/
    │               │
    │               ├── service/
    │               │
    │               ├── repository/
    │               │
    │               ├── entity/
    │               │
    │               ├── dto/
    │               │
    │               └── config/
    │
    └── resources/
        └── application.properties
```

---

# 👤 Customer Registration

Customer registration is currently implemented through a REST API.

### Registration Flow

```text
Frontend
   │
   │ POST /register
   ▼
Controller
   │
   │ @Valid
   ▼
CustomerRegisterDto
   │
   ▼
CustomerService
   │
   ▼
CustomerRepo
   │
   ▼
MySQL
```

---

## 📝 Customer Registration DTO

The registration DTO currently contains:

```text
email
username
name
phone
password
```

Validation is handled using Jakarta Bean Validation.

Example:

```java
@NotBlank
@Email
private String email;
```

```java
@NotBlank
@Size(min = 6, max = 10)
private String username;
```

```java
@NotBlank
@Size(min = 2, max = 30)
private String name;
```

```java
@NotBlank
@Pattern(
    regexp = "\d{10}",
    message = "Phone number must contain exactly 10 digits"
)
private String phone;
```

```java
@NotBlank
@Size(min = 8)
private String password;
```

Validation is triggered at the controller level using:

```java
@Valid
@RequestBody
```

---

# 🌐 Current API

## Register Customer

```http
POST /register
```

### Request

```json
{
    "email": "user@example.com",
    "username": "cargoUser",
    "name": "John Doe",
    "phone": "9876543210",
    "password": "yourPassword"
}
```

### Current Response

The registration endpoint currently returns a boolean:

```json
true
```

when registration succeeds.

```json
false
```

when the email or username already exists.

---

# 🗄️ Database

CargoZen currently uses **MySQL** as its relational database.

The application communicates with MySQL through:

```text
Spring Data JPA
       ↓
Hibernate
       ↓
MySQL Connector/J
       ↓
MySQL
```

The current `Customer` entity contains fields such as:

```text
id
email
username
name
phone
password
createdAt
```

Email and username are configured to be unique.

Example:

```java
@Column(nullable = false, unique = true)
private String email;
```

```java
@Column(nullable = false, unique = true)
private String username;
```

---

# 🔐 Password Security

CargoZen uses BCrypt for password hashing.

The intended flow is:

```text
User enters password
        ↓
HTTPS Request
        ↓
Spring Boot Backend
        ↓
BCrypt Password Encoder
        ↓
Hashed Password
        ↓
MySQL
```

Passwords should never be stored as plain text in the database.

During authentication, the entered password will be compared with the stored BCrypt hash rather than attempting to decrypt it.

---

# 🤖 AI Integration

One of CargoZen's main planned features is an **AI-powered vehicle recommendation system** using Spring AI.

The idea is to allow users to describe their cargo naturally.

For example:

```text
"I need to move a 6-foot sofa,
two chairs and a dining table."
```

The AI can eventually extract structured information such as:

```text
Cargo
├── Type
├── Quantity
├── Weight
├── Length
├── Width
└── Height
```

The extracted information can then be used to recommend an appropriate vehicle.

```text
Natural Language
      │
      ▼
   Spring AI
      │
      ▼
Cargo Information
      │
      ▼
Vehicle Recommendation
```

---

# 🚚 Planned Modules

CargoZen is planned to contain the following major modules:

```text
Customer
Driver
Vehicle
Cargo
Booking
Trip
Payment
Admin
```

### Customer

- Registration
- Login
- Profile management
- Create bookings
- View booking history

### Driver

- Driver registration
- Vehicle management
- Availability
- Accept/reject bookings
- Trip management

### Vehicle

- Vehicle type
- Load capacity
- Dimensions
- Availability
- Pricing

### Booking

- Customer
- Cargo
- Pickup location
- Drop location
- Vehicle
- Driver
- Booking status

---

# 🗺️ Planned Booking Flow

```text
Customer
    │
    ▼
Enter Cargo Details
    │
    ▼
AI Vehicle Recommendation
    │
    ▼
Select Vehicle
    │
    ▼
Enter Pickup & Drop Location
    │
    ▼
Create Booking
    │
    ▼
Driver Matching
    │
    ▼
Driver Accepts
    │
    ▼
Trip
    │
    ▼
Completion
    │
    ▼
Payment
```

---

# 📌 Development Status

### Completed

- [x] Spring Boot project setup
- [x] Spring Web
- [x] MySQL database connection
- [x] Spring Data JPA
- [x] Customer entity
- [x] Customer repository
- [x] Customer service
- [x] Customer registration DTO
- [x] Jakarta validation
- [x] Registration REST endpoint
- [x] Email uniqueness check
- [x] Username uniqueness check
- [x] Git repository setup

### In Progress

- [ ] BCrypt password encoding
- [ ] Login API
- [ ] Spring Security
- [ ] JWT authentication
- [ ] Role-based authorization

### Planned

- [ ] Driver module
- [ ] Vehicle module
- [ ] Cargo module
- [ ] Booking module
- [ ] Trip management
- [ ] Payment integration
- [ ] Spring AI integration
- [ ] AI cargo analysis
- [ ] AI vehicle recommendation
- [ ] Real-time tracking
- [ ] WebSocket
- [ ] Redis
- [ ] Testing
- [ ] Docker
- [ ] Deployment

---

# 🎯 Project Goal

The goal of CargoZen is to build a production-style logistics backend rather than a simple CRUD application.

The long-term vision is:

```text
        Cargo Description
               │
               ▼
          AI Analysis
               │
               ▼
       Cargo Information
               │
               ▼
     Vehicle Recommendation
               │
               ▼
           Booking
               │
               ▼
       Driver Assignment
               │
               ▼
             Trip
               │
               ▼
           Payment
```

CargoZen combines **Java, Spring Boot, MySQL, REST APIs, and Generative AI** to create an intelligent logistics platform.

---

## 👨‍💻 Author

**Tausif**

CargoZen is being developed as a full-stack Java project focused on combining **Spring Boot, modern backend architecture, logistics systems, and Generative AI**.
