package com.atm.servlet;

import com.atm.dao.ATMDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    private final ATMDAO dao = new ATMDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String upi = request.getParameter("upiId"), pin = request.getParameter("pin");
        try {
            double amount = Double.parseDouble(request.getParameter("amount"));
            if (upi == null || pin == null || upi.trim().isEmpty() || pin.trim().isEmpty() || !Double.isFinite(amount) || amount <= 0)
                throw new IllegalArgumentException("Enter valid credentials and an amount greater than zero.");
            double balance = dao.deposit(upi.trim(), pin.trim(), amount);
            request.setAttribute("message", String.format("Deposit successful! Updated balance: ₹%.2f", balance));
            request.setAttribute("success", true);
        } catch (ATMDAO.InvalidCredentialsException e) { request.setAttribute("message", "Invalid UPI ID or PIN."); }
          catch (IllegalArgumentException e) { request.setAttribute("message", e.getMessage() == null ? "Enter a valid amount." : e.getMessage()); }
          catch (Exception e) { log("Deposit failed", e); request.setAttribute("message", "Unable to process transaction. Please try again."); }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
