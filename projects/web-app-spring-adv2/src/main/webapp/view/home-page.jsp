<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Home page</title>
<style>body {background-color: aliceblue;}</style>
</head><body>

<h1>Home page</h1>
<hr/>

<form action="calculate-page" method="GET">
<p><label for="name1">Name 1: </label><input id="name1" name="name1"/></p>
<p><label for="name2">Name 2: </label><input id="name2" name="name2"/></p>
<input type="submit" value="calculate"/>
</form>

</body></html>
