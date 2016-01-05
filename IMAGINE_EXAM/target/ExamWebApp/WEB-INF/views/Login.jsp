<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

</head>

<body>

	<center>
		<form:form id="loginForm" method="post" action=""
			modelAttribute="loginBean">

			<table>

				<tr>

					<td><form:label path="username">user-name</form:label>
					</td>

					<td><form:input id="username" name="username" path="username" />
					</td>

				</tr>

				<tr>
					<td><form:label path="username">Password</form:label>
					</td>
					<td><form:password id="password" name="password"
							path="password" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>


			</table>


		</form:form>
	</center>

</body>

</html>
