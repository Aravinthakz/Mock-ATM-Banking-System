# Mock ATM Banking System

A Java Servlet + JSP + JDBC + MySQL web application matching the supplied project requirements.

## Requirements
- JDK 8 or later
- Apache Tomcat 9
- MySQL 8.x
- Maven 3.6+
- Eclipse IDE / Spring Tool Suite (STS)

## 1. Create the database
1. Open MySQL Workbench or the MySQL command line.
2. Run `database/atm_db.sql`.
3. This creates `atm_db`, the `account` table, and two sample accounts.

Sample login:
| UPI ID | PIN | Initial balance |
|---|---:|---:|
| student1@upi | 1234 | ₹5,000 |
| student2@upi | 5678 | ₹10,000 |

## 2. Configure MySQL connection
Open `src/main/java/com/atm/util/DBConnection.java` and replace:
`YOUR_MYSQL_PASSWORD`
with your local MySQL root password. Change USER if your MySQL username is different.

## 3. Import into STS / Eclipse
1. Extract the ZIP.
2. Open STS/Eclipse.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Select the extracted `Mock_ATM_Banking_System` folder.
5. Finish and wait for Maven dependencies to download.
6. Ensure the project uses JDK 8+ and a Tomcat 9 server runtime.

## 4. Run
1. Right-click project → **Run As → Run on Server**.
2. Select Apache Tomcat 9.
3. Open `http://localhost:8080/MockATM/`.

If the context path differs, use the path shown by your Tomcat server.

## Features
- Deposit: authenticates UPI ID/PIN, validates amount > 0 and updates balance.
- Withdraw: authenticates, validates amount > 0 and prevents overdrafts.
- View Balance: displays balance only after successful authentication.
- PreparedStatement is used for SQL operations.
- JDBC resources use try-with-resources.
- Deposit and withdrawal use database transactions and row locking.

## Project structure
```
Mock_ATM_Banking_System/
├── database/atm_db.sql
├── src/main/java/com/atm/
│   ├── dao/ATMDAO.java
│   ├── servlet/DepositServlet.java
│   ├── servlet/WithdrawServlet.java
│   ├── servlet/BalanceServlet.java
│   └── util/DBConnection.java
├── src/main/webapp/
│   ├── css/style.css
│   ├── index.jsp
│   ├── deposit.jsp
│   ├── withdraw.jsp
│   ├── balance.jsp
│   └── result.jsp
└── pom.xml
```

## Important notes
- This is an educational mock ATM, not a real banking application.
- The supplied specification stores PIN values as plain text; this demo follows that schema for compatibility. A production application must hash PINs/passwords, use HTTPS, add rate limiting, audit logs and stronger session/security controls.
- Do not use real bank credentials or real UPI PINs.
- If the database is reset, the sample balances are reset to the values in the SQL script.
