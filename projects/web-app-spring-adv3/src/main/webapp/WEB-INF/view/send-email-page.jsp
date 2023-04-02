<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Send Email</title>
<style>
body {background-color: #d2efc5;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1>Hi ${userInfoDto.name1}!</h1>
<h2>Send result to your email.</h2>

<form:form action="process-email" method="GET" modelAttribute="sendEmailDto">
    <p><label for="userEmail">Enter your email:</label>
    <form:input id="userEmail" path="userEmail"/>
    <input type="submit" value="Send"/></p>
</form:form>

</body></html>
