# 🍽️ FoodPilot Restaurant API

**FoodPilot** is a RESTful API built with **Quarkus** that manages restaurant data, allowing clients to retrieve, create, update, and delete restaurant records. It supports advanced filtering (like finding restaurants that are currently open), pagination, and is designed for scalability and ease of integration.

---

## 🚀 Features

- Retrieve all restaurants
- Get restaurant by ID
- Add, update, and delete restaurants
- Filter by cuisine type
- Find restaurants that are currently open
- Paginated results for large datasets
- Built with Quarkus and Panache for clean, efficient data access

---

## 📦 Tech Stack

- **Quarkus** (RESTEasy + Panache)
- **Hibernate ORM** (JPA)
- **Jakarta REST API**
- **Java 17+**
- **H2 / PostgreSQL / MySQL** (configurable)
- Optional: **Swagger UI** via OpenAPI

---

## 📘 API Endpoints

### 🔍 Get All Restaurants
```http
GET /restaurants
