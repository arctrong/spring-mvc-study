<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Result page (Spring)</title>
<style>body {background-color: #d2efc5;}</style>
</head><body>

<h1>Hi ${userInfoDto.name1}!</h1>

<h2>Email was successfully sent to ${sendEmailDto.userEmail}</h2>

</body></html>
