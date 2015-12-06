<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page import="com.studytrails.tutorials.springmvc.*, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<h2>List of Persons</h2>

	<table title="List Of Persons" border="1">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>

		<%
			List<Person> personList = (List) request.getAttribute("persons");
			for (Person person : personList) {
				out.println("<tr>");
				out.println("<td>" + person.getName() + "</td>");
				out.println("<td>" + person.getAge() + "</td>");
				out.println("</tr>");
			}
		%>

	</table>

	</ol>
</div>