<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Withdraw · Smart ATM</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="form-shell"><a class="back" href="index.jsp">← Back to home</a><div class="form-card"><div class="symbol">−</div><p class="eyebrow">TRANSACTION</p><h1>Withdraw money</h1><p class="sub">Enter your account details to withdraw funds.</p>
<form action="withdraw" method="post"><label>UPI ID</label><input name="upiId" type="text" placeholder="student1@upi" maxlength="50" required>
<label>PIN</label><input name="pin" type="password" placeholder="Enter your PIN" maxlength="20" required>
<label>Amount (₹)</label><input name="amount" type="number" min="0.01" step="0.01" placeholder="500.00" required>
<button type="submit">Withdraw money →</button></form></div></main></body></html>
