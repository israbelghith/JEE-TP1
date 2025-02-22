# JEE-TP1
This project is a Java EE web application for managing users and products using a MySQL database. It includes a login system with session validation. Users can add, search, and view products, and logout to clear their session. The application runs on Tomcat 9.0.97 and uses JSP, Servlets, JDBC, and JSTL for dynamic web content. 🚀
# JEE Project - User and Product Management

### ⚙️ Technologies Used:
- **Java EE (JSP, Servlets)**
- **Apache Tomcat 9.0.97**
- **MySQL**
- **JSTL**
- **JDBC (MySQL Connector 6.0.6)**

## 🚀 Features:
- **User authentication**
- **Session validation**
- **Menu options after login:**
  - Add a product
  - Search for a product
  - View all products
  - Logout (clear session)

## 🛠 Installation

### 1️⃣ Clone the repository:
```bash
git clone URL_TO_REPOSITORY
cd PROJECT_NAME
```

### 2️⃣ Import the project into an IDE (Eclipse/IntelliJ)
### 3️⃣ Add the required JAR files:
mysql-connector-java-6.0.6.jar
jstl.jar (or javax.servlet.jsp.jstl-xxx.jar if needed)

### 4️⃣ Set up the database:
Run the following SQL script to create the necessary tables:
```
CREATE TABLE utilisateurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE produit (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    quantite INT NOT NULL
);

```

### 5️⃣ Start XAMPP and access the application:
``` http://localhost:8080/PROJECT_NAME ```



