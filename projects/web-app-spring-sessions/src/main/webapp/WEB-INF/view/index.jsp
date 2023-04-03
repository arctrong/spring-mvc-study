<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Studying sessions</title>
<style>
body {background-color: plum;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1>Studying sessions</h1>
<hr />
<strong>First name: </strong>${firstName}<br />
<strong>Last name: </strong>${lastName}<br />
<strong>Address: </strong>${address}<br />
<hr />
<p>
<a href="${pageContext.request.contextPath}/ui/first">First</a> |
<a href="${pageContext.request.contextPath}/ui/second">Second</a> |
<a href="${pageContext.request.contextPath}/ui/third">Third</a> |
<a href="${pageContext.request.contextPath}/ui/normalMethod">Normal method</a> |
<a href="${pageContext.request.contextPath}/ui/invalidate">Invalidate session</a>
</p>

</body></html>
