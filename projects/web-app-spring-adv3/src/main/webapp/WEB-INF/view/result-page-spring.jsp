<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Result page (Spring)</title>
<style>body {background-color: aliceblue;}</style>
</head><body>

<h1>Result page (Spring)</h1>
<hr/>

<p>Name 1 is: ${dto.name1}</p>
<p>Name 2 is: ${dto.name2}</p>
<p>Result is: ${result} GOOD</p>

<p><a href="${pageContext.request.contextPath}/ui/sendEmail">Send result to your email</a></p>



</body></html>
