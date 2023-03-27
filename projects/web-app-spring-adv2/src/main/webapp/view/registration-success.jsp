<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Registration success</title>
<style>body {background-color: lemonchiffon;}</style>
</head><body>

<h1>Your registration is successful</h1>
<hr/>

<p>The details are:</p>
<strong>Name:</strong> ${userReg.name}<br/>
<strong>User name:</strong> ${userReg.userName}<br/>
<strong>Password:</strong> *****<br/>
<strong>Country:</strong> ${userReg.country}<br/>
<strong>Hobbies:</strong>
<c:forEach var="hobby" items="${userReg.hobbies}" varStatus="loop">
${hobby}<c:if test="${!loop.last}">, </c:if>
</c:forEach>
<br/>
<strong>Gender:</strong> ${userReg.gender}<br/>
<strong>Age:</strong> ${userReg.age}<br/>
<strong>Email:</strong> ${userReg.communicationDto.email}<br/>
<!-- <strong>Phone:</strong> ${userReg.communicationDto.phone}<br/> -->

</body></html>
