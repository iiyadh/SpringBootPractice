# 🧪 Lab 8 - Spring Boot Microservice-ish... Kind of... Almost

Welcome to **Lab 8**, where microservices were *supposed* to happen — but reality (a.k.a. **3 final exams in one day**) said **"Nope!"**

## 🤷‍♂️ The Plan (a.k.a. The Dream)

According to [the assignment](https://docs.teknolabs.net/courses/jee/module8/module8-lab-basic/), I was supposed to:

- Split the app into **multiple Spring Boot services**.
- Create different **REST APIs** for each service.
- Handle things like **Service Discovery**, **API Gateway**, **Docker**, **communication**, etc.
- Feel like a real backend architect™.

## 😩 The Reality

As a humble student of **ISETT**, I woke up one day and found myself with:

- **3 final exams** scheduled on the **same day**.  
- A sleep schedule held together with coffee and panic.  
- No time to be the Spring Boot god I aspire to be.

So instead of multiple cleanly separated microservice projects...  
You get **one monolithic-ish** repo that’s trying its best. 😅

## 📦 Project Structure (a.k.a. Microservice Cosplay)

```

Lab8/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── net/teknolabs/
│   │   │       └── lab8/
│   │   │           ├── controller/   <-- Pretending to be API Gateways
│   │   │           ├── entity/       <-- Not shared between services (because there’s only one)
│   │   │           ├── repository/   <-- Totally not micro, but very useful
│   │   │           └── service/      <-- Just enough logic to say “It’s modular-ish”
│   │   └── resources/
│   │       └── application.properties
└── README.md <-- You're reading this masterpiece

```

## 📚 Tech Stack

- Spring Boot (the MVP)
- Spring Data JPA
- H2 (because setting up a real DB felt like another exam)
- REST API (kinda... sorta... mostly)

## 🧠 Lessons Learned

1. Microservices are great — in theory. In practice? Not during exam season.
2. One repo is better than **no repo**.
3. I am a **normal human being**, not an API-producing machine.
4. Teachers, please — one final per day is the dream.

## 🚨 Disclaimer

This is not production-ready.  
This is *student-surviving-finals* ready.

Use it for learning, memes, or pity.

## ☕ Support

If you’d like to support this exhausted soul, please send:

- Coffee
- Sleep
- Exam reschedules

---
---

## 🏗️ **Real Microservice Architecture**

### 🧩 **Services Overview**

1. **Product Service**
   Handles product-related CRUD operations.

2. **Order Service**
   Manages orders (placing, listing, etc.), communicates with Product Service to validate product data.

3. **API Gateway (optional, for bonus)**
   Centralized entry point to route requests to the right microservice.

4. **Service Discovery (optional, for bonus)**
   Registers and discovers services dynamically (e.g., using Spring Cloud Eureka).

---

## 🗂️ **Folder Structure (Per Service – Multi-Project Setup)**

```
springboot-microservices-lab8/
├── product-service/
│   ├── src/main/java/com/example/product/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   ├── src/main/resources/
│   │   └── application.yml
│   └── pom.xml
│
├── order-service/
│   ├── src/main/java/com/example/order/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   ├── src/main/resources/
│   │   └── application.yml
│   └── pom.xml
│
├── api-gateway/  (optional)
│   ├── src/main/java/com/example/gateway/
│   └── application.yml
│
├── service-discovery/  (optional)
│   └── Spring Eureka server project
│
└── pom.xml  (parent project for all modules, if using Maven multi-module)
```

---

## 🔗 **Communication**

* Services communicate via **REST APIs**.
* Use **Feign Client** or **RestTemplate/WebClient** for inter-service communication.
* Add **DTOs** to transfer data between services.

---

## 🔧 **Tech Stack**

| Feature                   | Tool/Library                 |
| ------------------------- | ---------------------------- |
| Backend                   | Spring Boot                  |
| Inter-Service Calls       | Feign Client / RestTemplate  |
| DB for each service       | H2 / MySQL (one per service) |
| Service Discovery (bonus) | Spring Cloud Eureka          |
| Gateway (bonus)           | Spring Cloud Gateway         |
| Build Tool                | Maven                        |

---

## 🧠 Example: Product Service

```java
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }
}
```

## 🧠 Example: Order Service calling Product Service

```java
@Service
public class OrderService {
    @Autowired private RestTemplate restTemplate;

    public Order createOrder(Order order) {
        Product product = restTemplate.getForObject(
            "http://PRODUCT-SERVICE/products/" + order.getProductId(), Product.class
        );
        // validate & save order
    }
}
```


Made with ✨ desperation ✨ and 💻 caffeine by [@iiyadh](https://github.com/iiyadh)
