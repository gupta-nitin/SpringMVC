<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<form:errors path="stud.*"></form:errors>
	<h1>${headermsg}</h1>
	<h2>Student form</h2>
	<form action="/SpringMVC/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td>Student's Name :</td>
				<td><input type="text" name="studentName" /></td>

			</tr>
			<tr>
				<td>Student's Hobby :</td>
				<td><input type="text" name="studentHobby" /></td>

			</tr>
			<tr>
				<td>Student's mobile</td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>
			<tr>
				<td>Student's DOB</td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>
			<tr>
				<td>Student's skills</td>
				<td><select name="studentSkills" multiple="multiple">
						<option value="java core">Java Core</option>
						<option value="spring core">spring core</option>
						<option value="spring mvc">Spring MVC</option>
				</select></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Student's Address</td>
			</tr>
			<tr>
				<td>Country<input type="text" name="studentAddress.country" /></td>
				<td>City<input type="text" name="studentAddress.city" /></td>
				<td>Street<input type="text" name="studentAddress.street" /></td>
				<td>Pin code<input type="text" name="studentAddress.pin" /></td>
			</tr>
		</table>

		<input type="submit" value="Submit">
	</form>
</body>
</html>