<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Error</title>
<style>
body {background-color: darkslategray; color: coral; font-size: larger;}
a:link, a:visited, a:hover, a:active {color: wheat;}
strong {color: darksalmon;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1><code>NullPointerException</code> happened</h1>
<hr />
<p>We know about it and working on it. Sorry for your inconvenience.</p>

<hr />
<p>
<a href="${pageContext.request.contextPath}/ui/siteInfo">Site info</a>
</p>

</body></html>
