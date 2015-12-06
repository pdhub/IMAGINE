<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<html>
<head>

<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>

<style>
.box {
	width: 300px;
	height: 300px;
	background-color: #d9d9d9;
	position: fixed;
	font-family: verdana;
	margin-left: -150px; /* half of width */
	margin-top: -150px; /* half of height */
	top: 50%;
	left: 50%;
}

table.one {
	border-collapse: collapse;
	position: absolute;
	bottom: 50px;
	width: 70%;
	margin-left: 15%;
	margin-right: 15%
}

td.b {
	border-style: solid;
	border-width: 1px;
	border-color: #333333;
	padding: 10px;
	text-align: left;
}
</style>


<script>
	function getRadioValue(groupName) {
		var radios = theFormName.elements[groupName];
		window.rdValue; // declares the global variable 'rdValue'
		for (var i = 0; i < radios.length; i++) {
			var someRadio = radios[i];
			if (someRadio.checked) {
				rdValue = someRadio.value;
				break;
			} else
				rdValue = 'noRadioChecked';
		}

		document.getElementById('questionId').value = rdValue;
		/*if (rdValue != 'noRadioChecked') {
		    alert(rdValue); // or: console.log('10')
		}
		else if (rdValue == 'noRadioChecked') {
		    alert('no radio checked');
		}*/
	}
</script>



<script type="text/javascript">
	$(document).ready(function() {

		$('#theFormName').submit(function(event) {

			var theRadioGroupName = $('#theRadioGroupName').val();
			var json = {
				"theRadioGroupName" : theRadioGroupName
			};

			$.ajax({
				url : $("#theFormName").attr("action"),
				data : JSON.stringify(json),
				type : "POST",

				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {
					var respContent = "";

					respContent += "<span class='success'>Data was created: [";
					respContent += data.theRadioGroupName + "]</span>";

					$("#data").html(respContent);
				}
			});

			event.preventDefault();
		});

	});
</script>
<body>


</body>
<center class="box" border="1px">

	<spring:url var="action" value="/submitCurrentAns" />
	<form:form action="${action}">
		<table>

			<tr>${userExamView.currentQuestion.question}
				<INPUT TYPE="hidden" NAME="questionId"
					VALUE=${userExamView.currentQuestion.questionId}></INPUT>
				<INPUT TYPE="hidden" NAME="numQuestions"
					VALUE=${userExamView.numQuestions}></INPUT> numQuestions
			</tr>

			<c:forEach items="${userExamView.currentQuestion.answers}"
				var="answer">
				<tr>
					<td><INPUT TYPE="radio" NAME="answerId" VALUE=${answer.id}>${answer.answer}</INPUT>
					</td>
				</tr>
			</c:forEach>

		</table>
		<input type="submit" value="Save Answer" />
	</form:form>
</center>

<!--<c:forEach items="${QuestionsList}" var="question">
	<tr>${question.question}</tr>
	<c:forEach items="${question.answers}" var="answerEach">
		<tr>
			<td>${answerEach.id}</td>
			<td>${answerEach.answer}</td>
		</tr>
	</c:forEach>
</c:forEach>-->


<spring:url var="action" value="/getNewQuestion" />
<form:form action="${action}">

	<input type=hidden id=questionId value="1" />
	<c:forEach var="i" begin="1" end="${userExamView.numQuestions}">

		<c:if test="${i == userExamView.currentQuestion.questionId}">
			<INPUT TYPE="radio" NAME="theRadioGroupName" VALUE=${i
				}
				checked="checked">${i}</INPUT>
		</c:if>

		<c:if test="${i != userExamView.currentQuestion.questionId}">
			<INPUT TYPE="radio" NAME="theRadioGroupName" VALUE=${i}>${i}</INPUT>

		</c:if>

	</c:forEach>


	<input type="submit" value="Go" />

</form:form>



</html>