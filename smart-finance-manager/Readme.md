# Smart Personal Finance & Budget Management System

A **console-based Core Java application** to manage personal finances, track income and expenses, set monthly budgets, and analyze bank statements to generate meaningful financial insights.

This project is designed to practice **clean architecture, Core Java fundamentals, and real-world backend design principles** without using any external frameworks.

---

## 📌 Features

### 🔹 Core Finance Features

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

### 🔹 Bank Statement Analyzer (New Feature)

- Import transactions from a bank statement CSV file
- Automatic transaction mapping into the system
- One-click analysis (single menu option)
- Generates the following automatically:
  - Total income, total expense, and net savings
  - Monthly expense report
  - Category-wise expense breakdown
  - Top 5 highest expense transactions
  - Suspicious transaction detection
  - Predefined transaction search
- Analyzer operates **only on the Transaction Repository**
- No additional user input required during analysis

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
│ ├── BudgetService.java
│ ├── ReportService.java
│ └── BankStatementAnalyzerService
│
├── util/
│ ├── CsvUtil.java
│ └── InputValidator.java
│
└── data/
  └── transactions.csv
```

---

## ⚠️ IMPORTANT: `data/` Folder Rule

> 🚨 **DO NOT DELETE THE `data/` FOLDER — EVEN IF IT IS EMPTY**

### Why this is important:

- The application **expects the `data/` directory to exist**
- CSV files are used for **persistence and import/export**
- Bank statement CSV files are loaded from this folder
- Removing the folder will cause **runtime errors** during:
  - CSV import
  - report generation
  - data export

✔ Even if the folder is empty, it **must remain present** in the project root.

---

## 🧠 Architectural Design Decisions

### Layered Architecture

- **app** → Console interaction & menu handling
- **service** → Business logic, analysis, and reporting
- **repository** → Runtime data storage (single source of truth)
- **domain** → Core business entities
- **util** → Helper utilities (CSV, validation, formatting)

---

### Repository Pattern

- All business logic depends on the `TransactionRepository` interface
- Repository acts as the **single source of truth during runtime**
- CSV files are used **only for persistence and import**
- Enables easy future migration to a database

---

### Bank Statement Analyzer Design

- Implemented as a **service-layer feature**
- Bank CSV is read once and loaded into the repository
- All analysis runs on repository data
- Ensures consistency across:
  - reports
  - budgets
  - sorting
  - search

---

### Why No Separate Report Classes?

- Reports are generated and printed immediately
- They have no lifecycle or persistence
- Avoided unnecessary abstraction for clarity

---

## 🧪 Java Concepts Used

- Object-Oriented Programming (OOP)
- Encapsulation & immutability
- Enums (`Category`, `TransactionType`)
- Interfaces & loose coupling
- Repository pattern
- Singleton pattern (Budget)
- Collections (`ArrayList`, `EnumMap`)
- Java Streams API
- Date & Time API (`LocalDate`, `YearMonth`)
- File handling (CSV)
- Comparator-based sorting
- Input validation
- Clean architecture & separation of concerns

---

## ▶️ How to Run

1. Clone or download the project
2. Ensure the `data/` folder exists in the project root
3. (Optional) Place `bank_statement.csv` inside the `data/` folder
4. Compile and run:

```bash
cd src
javac */*.java
java app.FinanceApplication

🏁 Summary
This project demonstrates how a Core Java console application can evolve from a basic expense tracker into a feature-rich financial analysis system by following clean architecture principles and thoughtful backend design.
```
