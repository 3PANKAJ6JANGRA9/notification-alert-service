# Decoupled Notification Alert Service

A production-ready Spring Boot REST API that implements a decoupled notification dispatch system using **Dependency Injection (DI)** and the **Strategy Design Pattern**. 

This architecture allows the system to remain highly extensible. You can add new notification channels (e.g., Slack, Push Notifications) seamlessly by introducing a new component without altering any core business logic or controller code.

## 🛠️ Architecture Design Pattern
Instead of hardcoding conditional switch cases (`if channel == "sms"`), this project uses a dynamic registry map. At application startup, the Spring IoC Container automatically scans, instantiates, and injects all implementations of the `Notification` interface into the `NotificationService`.



---

## 🚀 Features
- **Dynamic Routing:** Dynamically maps requests to `Email`, `SMS`, or `WhatsApp` components at runtime.
- **Case Insensitivity:** Gracefully handles inputs like `WhatsApp`, `whatsapp`, or `WHATSAPP`.
- **Layered Architecture:** Strict separation of concerns across DTOs, Controllers, Services, and Component Strategies.

---

## 🚦 API Endpoints

### 1. Send a Notification
- **URL:** `/notification`
- **Method:** `POST`
- **Headers:** `Content-Type: application/json`
- **Sample Request Body:**
```json
{
    "channel": "WhatsApp",
    "recipient": "pankaj",
    "message": "how are you"
}
