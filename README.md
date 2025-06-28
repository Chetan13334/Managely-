# 💼 MANAGELY – EMPLOYEE MANAGEMENT SYSTEM

A full-stack web-based **Employee Management System** for company managers, built using **Spring Boot**, **React.js**, and **MySQL**. It allows managers to securely log in and perform essential operations such as **adding**, **viewing**, **updating**, and **deleting** employee records with a clean and modern interface.

---

## 🚀 FEATURES

- 🔐 Manager login with database-based authentication (Spring Security + Basic Auth)
- 👥 Manage employees: Add, View, Update, Delete (CRUD)
- 💾 MySQL database integration with JPA/Hibernate
- 📡 RESTful APIs using Spring Boot
- ⚛️ React.js frontend with modern UI and conditional form rendering
- 🧠 Modular architecture with reusable components and services

---

## 🧰 TECH STACK

| Layer       | Technology              |
|------------|--------------------------|
| Frontend    | React.js, Axios, CSS     |
| Backend     | Spring Boot, Spring Security |
| Database    | MySQL + JPA (Hibernate)  |
| API         | RESTful (JSON)           |
| Auth        | HTTP Basic Authentication |
| Tools       | Git, VS Code, IntelliJ, Postman |

---

## 📁 PROJECT STRUCTURE

```
Managely/
├── backend/ (Spring Boot app)
│   ├── src/main/java/com/managely/
│   │   ├── models/
│   │   ├── controllers/
│   │   ├── repository/
│   │   └── services/
│   └── resources/application.properties
│
├── managely-frontend/ (React app)
│   ├── public/
│   └── src/
│       ├── components/
│       ├── Dashboard.js
│       ├── Login.js
│       └── Dashboard.css
```

---

## ⚙️ SETUP INSTRUCTIONS

### 📦 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/managely.git
cd managely
```

### 🔧 2. Setup Backend (Spring Boot)

- Create your **MySQL database** named `managely`
- Set DB credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/managely
spring.datasource.username=root
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update
```

- Then run the backend:

```bash
cd backend
./mvnw spring-boot:run
```

(Or use IntelliJ/VS Code to run the `ManagelyApplication` class)

---

### 🌐 3. Setup Frontend (React)

```bash
cd managely-frontend
npm install
npm start
```

Access the frontend at: [http://localhost:3000](http://localhost:3000)

---
