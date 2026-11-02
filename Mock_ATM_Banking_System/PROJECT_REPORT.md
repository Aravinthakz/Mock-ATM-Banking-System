# Mock ATM Banking System — Project Report

## 1. Project Overview
The Mock ATM Banking System is a database-driven web application that simulates basic ATM operations. Users authenticate using a UPI ID and PIN and can deposit money, withdraw money, or view their current account balance.

## 2. Technologies Used
- Java: application logic
- Java Servlets: process browser requests
- JSP: user interface pages
- JDBC: database connectivity
- MySQL: account data storage
- Apache Tomcat 9: servlet container and web server
- HTML and CSS: responsive user interface
- Maven: dependency and build management

## 3. Database Design
Database: `atm_db`

Table: `account`

| Column | Type | Constraint |
|---|---|---|
| upi_id | VARCHAR(50) | Primary key |
| pin | VARCHAR(20) | Not null |
| amount | DOUBLE | Not null |

Two sample accounts are inserted by the SQL script: `student1@upi` and `student2@upi`.

## 4. Application Flow
1. The user opens the home page.
2. The user selects Deposit, Withdraw, or View Balance.
3. The user enters UPI ID and PIN; deposit and withdrawal also require an amount.
4. The servlet validates the request and calls the DAO.
5. The DAO authenticates the account using a PreparedStatement.
6. For deposit/withdrawal, the DAO locks the account row, checks the balance where necessary, updates the balance, and commits the transaction.
7. The result page displays a success or error message.

## 5. Main Modules
- DepositServlet: validates and processes deposits.
- WithdrawServlet: validates and processes withdrawals and prevents negative balances.
- BalanceServlet: authenticates and displays the current balance.
- ATMDAO: contains JDBC database operations.
- DBConnection: creates MySQL connections.

## 6. Screenshots
Capture screenshots after running the application:
- Home page
- Deposit page
- Withdraw page
- View balance result
- MySQL `account` table

Paste the screenshots here before submission.

## 7. Conclusion
The project demonstrates how Java Servlets and JSP handle web requests and how JDBC connects a Java web application to MySQL. It also demonstrates authentication, validation, database updates, and transaction handling.
