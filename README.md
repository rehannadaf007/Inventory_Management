<h1 align="center">📦 Inventory Management System</h1>

<p align="center">
✨ A Smart <b>Java Console Application</b> for managing inventory, tracking stock, and calculating profit/loss efficiently.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Backend-blue?style=for-the-badge&logo=java">
  <img src="https://img.shields.io/badge/Console-App-green?style=for-the-badge">
  <img src="https://img.shields.io/badge/Data-HashMap-orange?style=for-the-badge">
  <img src="https://img.shields.io/badge/OOP-Concepts-purple?style=for-the-badge">
</p>

---

## 🌟 Features

✨ Easy product management  
📦 Add / Update stock  
💰 Profit & Loss calculation  
📊 Purchase reports  
⚡ Fast data handling using HashMap  
🧠 Object-Oriented Design  

---

## 🖥️ User Menu

```bash
1. List all products
2. Display individual product info
3. Purchase (add stock)
4. Shipping (sell stock)
5. Balance stock
6. Calculate loss and profit
7. Purchase report
8. Exit

        👤 User
          │
          ▼
     Main (UI Layer)
          │
          ▼
   StockManager (Logic)
          │
          ▼
     Product (Model)
          │
          ▼
   Inventory (HashMap)

Start → Menu → User Input → Process → Update Stock → Profit/Loss → Exit

📦 inventory_management
 ┣ 📜 Main.java
 ┣ 📜 Product.java
 ┣ 📜 StockManager.java
 ┗ 📜 README.md

Product p = new Product("P001", "Laptop", 1200.00, 5);

Map<String, Product> inventory = new HashMap<>();

javac Main.java Product.java StockManager.java

java Main

✔ Product Purchased Successfully!
📦 Laptop → Stock: 10 units
