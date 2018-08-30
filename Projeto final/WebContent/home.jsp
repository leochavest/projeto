<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quentinha Online</title>
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
</style>
</head>
<body>
<h1>Bem vindo ao Quentinha Online</h1>
<div id="cardapio"><jsp:include page="cardapio.jsp"></jsp:include></div>

</body>
</html>