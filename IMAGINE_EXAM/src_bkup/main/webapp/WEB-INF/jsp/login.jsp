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

<!-- <div style="text-align: center; padding: 30px;border: 1px solid green;width: 250px;">  
   <form method="post" action="<c:url value='j_spring_security_check' />">  
  
    <table>  
     <tr>  
      <td colspan="2" style="color: red">${message}</td>  
  
     </tr>  
     <tr>  
      <td>User Name:</td>  
      <td><input type="text" name="username" />  
      </td>  
     </tr>  
     <tr>  
      <td>Password:</td>  
      <td><input type="password" name="password" />  
      </td>  
     </tr>  
     <tr>  
      <td> </td>  
      <td><input type="submit" value="Login" />  
      </td>  
  
     </tr>  
    </table>  
   </form>  
  </div>  -->




	<center>

		<textarea name="paragraph_text" cols="50" rows="10"
			readonly="readonly" ALIGN=LEFT>${examDesc.desc}</textarea>

		<form:form id="loginForm" method="post" action=""
			modelAttribute="loginBean">

			<table>

				<tr>

					<td><form:label path="username">Enter your user-name</form:label>
					</td>

					<td><form:input id="username" name="username" path="username" />
						<form:errors path="username" /></td>
					</td>

				</tr>

				<tr>
					<td><form:label path="username">Please enter your password</form:label>
					</td>
					<td><form:password id="password" name="password"
							path="password" /> <form:errors path="password" /></td>
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>


			</table>


		</form:form>

	</center>

</body>

</html>
