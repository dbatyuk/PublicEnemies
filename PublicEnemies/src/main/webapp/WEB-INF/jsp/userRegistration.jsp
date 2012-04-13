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
			<td align="center">
				<form action="userRegistration.html" method="post">
					<spring:bind path="userToRegister.email">
						<p>Login</p>
						<input type="text" name="email" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<spring:bind path="userToRegister.password">

						<p>Password</p>
						<input type="password" name="password" ${status.value}>

						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<button type="submit" class="button">Register</button>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>