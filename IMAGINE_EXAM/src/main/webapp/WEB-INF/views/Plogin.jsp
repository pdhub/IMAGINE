<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>

</head>

<script>

function jsonCheck(){
	alert('Going');
	var xmlHttp;
	xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function(){

		
		//if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
		if(xmlHttp.readyState == 4){
			alert('updating');
			var jsonObj = JSON.parse(xmlhttp.responseText);
			updateValues(jsonObj);
		}

		
	};
	xmlHttp.open("GET", "getUserName", true);
	xmlHttp.send();
}

function updateValues(arr){
	for (i = 0; i < arr.length; i++) 
	{
		document.getElementById("Name").innerHTML = arr[i].name;
	}
}
</script>

<body>


	<form:form id="loginForm" method="post" action="login"
		modelAttribute="loginBean">

		<table>
			<tr>
				<td><form:label path="username">User-name</form:label></td>
				<td><form:input id="username" name="username" path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="username">Password</form:label></td>
				<td><form:password id="password" name="password" path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<form:form id="loginForm" method="POST" action="registerUser">
		<input type="submit" value="Register" />
	</form:form>

<!-- JSON output data test here -->

<table>
<tr>
<td><div id="Name"></div></td>
</tr>
</table>

</body>

</html>
