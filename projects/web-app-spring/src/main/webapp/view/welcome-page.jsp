<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>My cafe</title>
<style>body {background-color: aliceblue;}</style>
</head><body>

<h1>My cafe</h1>
<hr/>
<form action="cafe/processOrder" method="POST">
<label for="itemName">Item name:</label>
<input id="itemName" type="text" name="itemName"/>
<input type="submit" value="Order now!"/>
</form>

</body></html>
