<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game</title>
</head>
<body>
	<table>
		<tr>
			<td id="interactive" align="center">
				<form action="newGame.html" method="post">
					<spring:bind path="gameToCreate.name">
						<p>New game:</p>
						<input type="text" name="name" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<button type="submit" id="button">Create</button>
				</form>
				<form action="joinGame.html" method="post">
					<spring:bind path="gameToJoin.name">
						<p>Join game:</p>
						<input type="text" name="name" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br/>
					</spring:bind>
					<button type="submit" id="button">Join</button>
				</form> <a href="userStartPage.html">Back</a>
			</td>
		</tr>
	</table>
</body>
</html>