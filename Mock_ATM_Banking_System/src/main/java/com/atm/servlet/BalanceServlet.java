package com.atm.servlet;

import com.atm.dao.ATMDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    private final ATMDAO dao = new ATMDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String upi = request.getParameter("upiId"), pin = request.getParameter("pin");
        try {
            if (upi == null || pin == null || upi.trim().isEmpty() || pin.trim().isEmpty())
                throw new IllegalArgumentException("Enter your UPI ID and PIN.");
            Double balance = dao.getBalance(upi.trim(), pin.trim());
            if (balance == null) request.setAttribute("message", "Invalid UPI ID or PIN.");
            else {
                request.setAttribute("message", String.format("Your current balance is ₹%.2f", balance));
                request.setAttribute("success", true);
            }
        } catch (IllegalArgumentException e) { request.setAttribute("message", e.getMessage()); }
          catch (Exception e) { log("Balance lookup failed", e); request.setAttribute("message", "Unable to retrieve balance. Please try again."); }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
