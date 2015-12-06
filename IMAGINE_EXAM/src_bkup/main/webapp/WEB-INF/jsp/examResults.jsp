<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<html>
<head>
</head>
<body>

<center>
<h3>Here are your results</h3>
<table border="1">
<tr>
<td>User Name</td>
<td>Correct Ans</td>
</tr>
		<tr>
			<td>${examResultView.userId}</td>
			<td>${examResultView.result}</td>
		</tr>
</table>
</center>	

</body>
</html>