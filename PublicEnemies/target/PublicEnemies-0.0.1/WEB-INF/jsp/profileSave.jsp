<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save profile</title>
</head>
<body>
	<table>
		<tr>
			<td align="center">
				<form action="profileSave.html" method="post">
					<spring:bind path="profileToSave.nickName">
						<p>Nickname:</p>
						<input type="text" name="nickName" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<spring:bind path="profileToSave.avatar">
						<p>Avatar:</p>
						<input type="text" name="avatar" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<spring:bind path="profileToSave.gender">
						<p>Gender:</p>
						<input type="text" name="gender" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<spring:bind path="profileToSave.proffesion">
						<p>Proffesion:</p>
						<input type="text" name="proffesion" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<button type="submit" class="button">Save profile!</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>