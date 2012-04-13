<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fight!</title>
</head>
<body>
	<table>
		<tr>
			<td id="interactive" align="center">
				<form action="fightHit.html" method="post">
					<spring:bind path="fightHit.toHit">
						<p>To hit:</p>
						<input type="text" name="toHit" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>

					<spring:bind path="fightHit.toBlock">
						<p>To block:</p>
						<input type="text" name="toBlock" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<button type="submit" id="button">Get hit</button>
				</form> <a href="userStartPage.html">Back</a>
			</td>
		</tr>
	</table>
</body>
</html>