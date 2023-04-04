<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Home page (validated)</title>
<style>
body {background-color: aliceblue;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1>Home page (validated)</h1>
<hr/>

<form:form action="validate-submit" method="GET" modelAttribute="userInfoDto">
    <p><label for="name1">Name 1: </label><form:input id="name1" path="name1"/>
    <form:errors path="name1" cssClass="error"/></p>

    <p><label for="name2">Name 2: </label><form:input id="name2" path="name2"/>
    <form:errors path="name2" cssClass="error"/></p>

    <p><form:checkbox path="notARobot" id="notARobot"/>
    <label for="notARobot">I am not a robot</label>
    <form:errors path="notARobot" cssClass="error"/></p>

    <input type="submit" value="calculate"/>
</form:form>

</body></html>
