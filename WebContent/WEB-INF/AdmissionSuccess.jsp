<html>
<head>
</head>
<body>
<h1>${headermsg}</h1>
	<table>
		<tr>
			<td>Name is : </td>
			<td>${stud.studentName}</td>
		</tr>
		
		<tr>
			<td>Hobby is :</td>
			<td>${stud.studentHobby}</td>
		</tr>
		
		<tr>
			<td>Mobile is :</td>
			<td>${stud.studentMobile}</td>
		</tr>
		
		<tr>
			<td>DOB is</td>
			<td>${stud.studentDOB}</td>
		</tr>
		<tr>
			<td>Skills are</td>
			<td>${stud.studentSkills}</td>
		</tr>
		<tr>
			<td>Address is</td>
			<td>${stud.studentAddress.country}</td>
			<td>${stud.studentAddress.city}</td>
			<td>${stud.studentAddress.street}</td>
			<td>${stud.studentAddress.pin}</td>
		</tr>
		
		
	</table>
</body>
</html>