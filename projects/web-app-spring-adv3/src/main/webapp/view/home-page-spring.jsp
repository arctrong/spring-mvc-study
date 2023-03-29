<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Home page (Spring)</title>
<style>body {background-color: aliceblue;}</style>
</head><body>

<h1>Home page with Spring form</h1>
<hr/>

<form:form action="calculate-page-springs" method="GET" modelAttribute="userInfo">
<p><label for="name1">Name 1: </label><form:input id="name1" path="name1"/></p>
<p><label for="name2">Name 2: </label><form:input id="name2" path="name2"/></p>
<input type="submit" value="calculate"/>
</form:form>

</body></html>
