<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<title>Public Enemies login</title>

</head>
<body>
	<table>
		<tr>
			<td id="interactive" align="center">
				<form action="userLogin.html" method="post">
					<spring:bind path="userToLogin.email">
					<p>Login</p>
						<input type="text" name="email" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<spring:bind path="userToLogin.password">
					<p>Password</p>
						<input type="password" name="password" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<button type="submit" id="button">Login</button>
					<a href="userRegistration.html">Register</a>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>