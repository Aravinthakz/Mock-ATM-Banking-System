CREATE DATABASE IF NOT EXISTS atm_db;
USE atm_db;

CREATE TABLE IF NOT EXISTS account (
    upi_id VARCHAR(50) PRIMARY KEY,
    pin VARCHAR(20) NOT NULL,
    amount DOUBLE NOT NULL
) ENGINE=InnoDB;

INSERT INTO account (upi_id, pin, amount) VALUES
('student1@upi', '1234', 5000.00),
('student2@upi', '5678', 10000.00)
ON DUPLICATE KEY UPDATE pin=VALUES(pin), amount=VALUES(amount);
