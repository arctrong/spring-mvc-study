<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>Registration</title>
<style>
body {background-color: lemonchiffon; text-align: center;}
.error {color: red; position: fixed; text-align: left; margin-left: 20px;}
</style>
</head><body>

<h1>Please register here</h1>
<hr/>

<form:form action="registration-success" method="GET" modelAttribute="userReg">
</p><label for="name">Name: </label><form:input id="name" path="name"/>
<form:errors path="name" cssClass="error"/></p>
</p><label for="userName">User name: </label><form:input id="userName" path="userName"/>
<form:errors path="userName" cssClass="error"/></p>
</p><label for="password">Password: </label><form:password id="password" path="password"/></p>
</p><label for="country">Country: </label><form:select id="country" path="country">
<form:option value="AV" label="Avalon"/>
<form:option value="CM" label="Camelot"/>
<form:option value="EL" label="Elysium"/>
</form:select></p>
</p><label>Hobbies: </label>
<form:checkbox path="hobbies" id="cooking" value="cooking"/><label for="cooking">Cooking</label>
<form:checkbox path="hobbies" id="eating" value="eating"/><label for="eating">Eating</label>
<form:checkbox path="hobbies" id="walking" value="walking"/><label for="walking">Walking</label>
<form:checkbox path="hobbies" id="travel" value="travel"/><label for="travel">Travel</label>
</p>
</p><label>Gender: </label>
<form:radiobutton path="gender" id="male" value="M"/><label for="male">Male</label>
<form:radiobutton path="gender" id="female" value="F"/><label for="female">Female</label>
</p>

</p><label for="age">Age: </label><form:input id="age" path="age"/>
<form:errors path="age" cssClass="error"/></p>

<p>Communication:</p>
</p><label for="email">Email: </label><form:input id="email" path="communicationDto.email"/>&nbsp;
<label for="phone">Phone: </label><form:input id="phone" path="communicationDto.phone"/></p>

<input type="submit" value="register"/>
</form:form>

</body></html>
