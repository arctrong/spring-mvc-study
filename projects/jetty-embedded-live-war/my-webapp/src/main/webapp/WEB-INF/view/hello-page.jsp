<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Hello JSP page</title>
</head><body>

<h1>Hello JSP page</h1>
<hr/>

<p><a href="${pageContext.request.contextPath}/">Go to the home page</a></p>

<p>The generated servlet class is:
<code><%= this.getClass().getSimpleName() %></code></p>

<p>Counting to three:
<% for (int i=1; i<4; i++) { %>
    <%= i %>,
<% } %>
OK.</p>

</body></html>
