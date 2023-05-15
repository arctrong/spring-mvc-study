<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>System properties</title>
<style>table{border-collapse:collapse;}td,th{border:solid black 1px;vertical-align:top;padding:5px;}
</style>
</head><body>

<h1>System properties</h1>
<hr/>
<p><a href="${pageContext.request.contextPath}/">To the home page</a></p>

<p style='color:red;'>This table is just for demonstration. It is insecure
to use it in a production environment.</p>

<table><thead><tr><th>Key</th><th>Value</th></tr></thead><tbody>
<% for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) { %>
    <tr><td><%= entry.getKey() %></td><td><%= entry.getValue() %></td></tr>
<% } %>
</tbody></table>

</body></html>
