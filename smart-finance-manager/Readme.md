# Smart Personal Finance & Budget Management System

A **console-based Java application** to manage personal finances, track income and expenses, set monthly budgets, and generate financial reports.

This project is designed to practice **clean architecture, Core Java concepts, and real-world backend design principles** without using any external frameworks.

---

## 📌 Features

- Add income and expense transactions
- Monthly financial report (income, expense, net balance)
- Category-wise expense summary (month-based)
- Monthly budget tracking per category
- Budget status detection:
  - Within budget
  - Budget used fully
  - Out of budget
- Sort transactions by:
  - Amount (ascending / descending)
  - Date (ascending / descending)
- Input validation for dates and numeric values
- Clean separation of concerns using layers

---

## 🏗️ Project Structure

```
src/
├── app/
│ └── FinanceApplication.java
│
├── config/
│ └── AppConfig.java
│
├── domain/
│ ├── Transaction.java
│ └── Budget.java
│
├── enums/
│ ├── Category.java
│ └── TransactionType.java
│
├── repository/
│ └── TransactionRepository.java
│
├── service/
│ ├── TransactionService.java
│ └── BudgetService.java
│
├── util/
│ ├── CsvUtil.java
│ └── InputValidator.java
└──data/
    └── (CSV files will be generated here)
```

---

## ⚠️ IMPORTANT: `data/` Folder Rule

> 🚨 **DO NOT DELETE THE `data/` FOLDER — EVEN IF IT IS EMPTY**

### Why this is important:

- The application **expects the `data/` directory to exist**
- CSV files for transactions and reports are generated inside this folder
- Removing the folder will cause **runtime errors** during:
  - report generation
  - CSV export
  - file persistence operations

✔ Even if the folder is empty, it **must remain present** in the project root.

---

## 🧠 Architectural Design Decisions

### Layered Design

- **app** → User interaction & console output
- **service** → Business logic and calculations
- **repository** → Data storage abstraction
- **domain** → Core business entities
- **util** → Helper utilities (CSV, input validation)

### Repository Pattern

- Storage is abstracted using a `TransactionRepository` interface
- Business logic depends on the interface, not the implementation
- Makes it easy to replace in-memory storage with CSV or database later

### Why No Report Classes?

- Reports are generated and printed immediately
- They have no lifecycle or persistence
- Avoided unnecessary abstraction for simplicity and clarity

---

## 🧪 Java Concepts Used

- Object-Oriented Programming (OOP)
- Encapsulation & immutability
- Enums (`Category`, `TransactionType`, `Status`)
- Interfaces & loose coupling
- Repository pattern
- Singleton pattern (Budget)
- Collections (`ArrayList`, `EnumMap`)
- Date & Time API (`LocalDate`, `YearMonth`)
- Input validation
- File handling (CSV)
- Comparator-based sorting
- Clean architecture & separation of concerns

---

## ▶️ How to Run

1. Clone or download the project
2. Ensure the `data/` folder exists in the project root
3. Compile and run:

```bash
cd src
javac */*.java
java app.FinanceApplication
```
