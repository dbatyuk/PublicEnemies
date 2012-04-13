<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Public Enemies</title>
<style type="text/css">
body {
	background-image:
		url("img/background.jpg");
}

h2 {
	color: white
}

button {
	font: normal 12px arial, sans-serif;
	height: 24px;
	width: 60 px;
	margin-bottom: 90px;
}
table{ 
	background-color: white; 
	opacity: .8;
	filter: alpha(opacity=80);
		-moz-opacity: .8;
}
</style>
</head>
<body>
	<table align="center">
		<tr>
			<td width="150">
				Level - 10
			</td>
			<td width="150">
				HP - 88
			</td>
			<td width="150">
				Strength - 16
			</td>
			<td width="150">
				Agility - 22
			</td>
			<td width="150">
				$ - 5500
			</td>
		</tr>
		<tr>
			<table border="4" style="background-color: #444D48;">
				<tr border="3">
					<!-- Left column -->
					<td width="150" align="center">
						<table>
							<button>Profile</button><br />
							<button>Inventory</button><br />
							<button>Shop</button><br />
							<button>Statistics</button><br />
						</table>
					</td>
					<td align="center" width="800">
						<table>
							<tr>
								<td width="300" height="270">
									<img src="http://themafiagamenhs.webs.com/HeaderBoss.JPG" width="300"></img>
								</td>
								<td width="500" height="270" colspan="2" align="center">
									<table>
										<button>Profile</button><br />
										<button>Inventory</button><br />
										<button>Shop</button><br />
										<button>Statistics</button><br />
									</table>
								</td>
							</tr>
							<tr>
								<td height="270">
									<a href="shop.html">Your inventory</a>
								</td>
							</tr>
						</table>
					</td>
					<td align="center" width="350">
						<table width="350" height="550" border="4" cellspacing="0" cellpadding="0" >
							<tr>
								<td>
									<h1>List of active players/games</h1>
								</td>
							</tr>
							<tr>
								<td>
									<h1>Chat</h1>
								</td>
							</tr>	
						</table>
					</td>
				</tr>
			</table>
		</tr>
	</table>
<a href="userLogin.html">Back</a>
<a href="logout.html">Logout</a>

</body>
</html>
