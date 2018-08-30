<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
<style type="text/css">
#main {
	width: 800px;
	padding: 0;
	margin-left: auto;
	margin-right: auto;
}

#header {
	height: 50px;
	background-color: #F5F5F5;
	border: 1px solid #CDCDCD;
	margin-bottom: 5px;
	margin-top: 5px;
}

#menu {
	height: 50px;
	line-height: 30px;
	border: 1px solid #CDCDCD;
	background-color: #F5F5F5;
	margin-bottom: 5px;
	clear: both;
}

#corpo {
	width: 800px;
	min-height: 230px;
	border: 1px solid #CDCDCD;
	float: left;
	margin-bottom: 5px;
	clear: both;
}

#rodape {
	height: 50px;
	clear: both;
	border: 1px solid #CDCDCD;
	background-color: #F8F8FF;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

		<div id="header">
			<div id='menungang'>
				<ul>
					<li class='last'><a href="home.jsp"><span>Home</span></a></li>
					<c:choose>
						<c:when test="{not empty username}">
							<li class='last'><a href="pedido.jsp"><span>Pedido</span></a></li>
							<li class='last' ><a
								href="LogoutServlet"><span>Sair</span></a></li>
							<li class='last' ><a
								href="update_user.jsp?username=${username}"><span>${username}</span></a></li>
						</c:when>
						<c:when test="{empty username}">
							<li class='last'><a
								href="index.jsp"><span>Login</span></a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
</body>
</html>