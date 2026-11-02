package com.atm.dao;

import com.atm.util.DBConnection;
import java.sql.*;

public class ATMDAO {
    public Double getBalance(String upi, String pin) throws SQLException {
        String sql = "SELECT amount FROM account WHERE upi_id=? AND pin=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, upi); ps.setString(2, pin);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? rs.getDouble("amount") : null; }
        }
    }

    public double deposit(String upi, String pin, double amount) throws SQLException {
        return updateBalance(upi, pin, amount, true);
    }

    public double withdraw(String upi, String pin, double amount) throws SQLException {
        return updateBalance(upi, pin, amount, false);
    }

    private double updateBalance(String upi, String pin, double amount, boolean deposit) throws SQLException {
        String select = "SELECT amount FROM account WHERE upi_id=? AND pin=? FOR UPDATE";
        String update = "UPDATE account SET amount=? WHERE upi_id=? AND pin=?";
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);
            try {
                double balance;
                try (PreparedStatement ps = con.prepareStatement(select)) {
                    ps.setString(1, upi); ps.setString(2, pin);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) throw new InvalidCredentialsException();
                        balance = rs.getDouble("amount");
                    }
                }
                if (!deposit && amount > balance) throw new InsufficientBalanceException();
                double newBalance = deposit ? balance + amount : balance - amount;
                try (PreparedStatement ps = con.prepareStatement(update)) {
                    ps.setDouble(1, newBalance); ps.setString(2, upi); ps.setString(3, pin);
                    ps.executeUpdate();
                }
                con.commit();
                return newBalance;
            } catch (SQLException | RuntimeException e) {
                con.rollback();
                throw e;
            } finally { con.setAutoCommit(true); }
        }
    }

    public static class InvalidCredentialsException extends SQLException {
        public InvalidCredentialsException() { super("Invalid UPI ID or PIN."); }
    }
    public static class InsufficientBalanceException extends SQLException {
        public InsufficientBalanceException() { super("Insufficient Balance."); }
    }
}
