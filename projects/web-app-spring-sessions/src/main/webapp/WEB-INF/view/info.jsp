<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Using @ModelAttribute</title>
<style>
body {background-color: darkslategray; color: wheat; font-size: larger;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1>Using @ModelAttribute at the method level</h1>
<hr />
<strong>Website name: </strong>${websiteInfo.websiteName}<br />
<strong>Website category: </strong>${websiteInfo.websiteCategory}<br />

</body></html>
