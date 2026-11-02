<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Transaction result · Smart ATM</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="form-shell"><div class="form-card result"><div class="result-icon"><%= Boolean.TRUE.equals(request.getAttribute("success")) ? "✓" : "!" %></div>
<p class="eyebrow">TRANSACTION STATUS</p><h1><%= Boolean.TRUE.equals(request.getAttribute("success")) ? "All done" : "Please check" %></h1>
<p class="message"><%= request.getAttribute("message") == null ? "No result available." : String.valueOf(request.getAttribute("message")) %></p>
<a class="button-link" href="index.jsp">Return to home →</a></div></main></body></html>
