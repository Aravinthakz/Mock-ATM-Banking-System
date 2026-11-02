<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Balance · Smart ATM</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="form-shell"><a class="back" href="index.jsp">← Back to home</a><div class="form-card"><div class="symbol">◉</div><p class="eyebrow">ACCOUNT</p><h1>View balance</h1><p class="sub">Authenticate to view your current balance.</p>
<form action="balance" method="post"><label>UPI ID</label><input name="upiId" type="text" placeholder="student1@upi" maxlength="50" required>
<label>PIN</label><input name="pin" type="password" placeholder="Enter your PIN" maxlength="20" required>
<button type="submit">Check balance →</button></form></div></main></body></html>
