<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Deposit · Smart ATM</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="form-shell"><a class="back" href="index.jsp">← Back to home</a><div class="form-card"><div class="symbol">＋</div><p class="eyebrow">TRANSACTION</p><h1>Deposit money</h1><p class="sub">Enter your account details to add funds.</p>
<form action="deposit" method="post"><label>UPI ID</label><input name="upiId" type="text" placeholder="student1@upi" maxlength="50" required>
<label>PIN</label><input name="pin" type="password" placeholder="Enter your PIN" maxlength="20" required>
<label>Amount (₹)</label><input name="amount" type="number" min="0.01" step="0.01" placeholder="1000.00" required>
<button type="submit">Deposit money →</button></form></div></main></body></html>
