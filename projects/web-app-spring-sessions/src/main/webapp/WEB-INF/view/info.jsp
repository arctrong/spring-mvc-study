<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Using @ModelAttribute</title>
<style>
body {background-color: darkslategray; color: wheat; font-size: larger;}
a:link, a:visited, a:hover, a:active {color: wheat;}
strong {color: darksalmon;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1>Using @ModelAttribute at the method level</h1>
<hr />
<strong>Website name: </strong>${websiteInfo.websiteName}<br />
<strong>Website category: </strong>${websiteInfo.websiteCategory}<br />

<hr />
<p>
<a href="${pageContext.request.contextPath}/ui/siteInfo">Site info</a> |
<a href="${pageContext.request.contextPath}/ui/companyInfo">Company info</a> |
<a href="${pageContext.request.contextPath}/ui/test">Test info</a> |
<a href="${pageContext.request.contextPath}/ui/errorInfo">Error info</a>
</p>

</body></html>
