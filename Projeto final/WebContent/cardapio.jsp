<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cardapio</title>
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
	<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
	<h5>Todas as nossas comidas são feitas com qualidade e amor, sempre serão entregues o mais rápido possível. </h5>
	<table style="width: 100%">
		<tr>
			<th>Proteina</th>
			<th>Acompanhamentos</th>
			<th>Preço</th>
			<th>Pedir</th>
		</tr>
		<tr>
			<td>Carne</td>
			<td>Arroz, feijão e batata frita.</td>
			<td>13,00</td>
			<td><button type="submit" onclick="alert('Pedido Salvo')">
					Pedir prato 1</button>
			<td />

		</tr>
		<tr>
			<td>Frango</td>
			<td>Arroz, feijão e batata frita</td>
			<td>11,00</td>
			<td><button type="submit" onclick="alert('Pedido Salvo')">
					Pedir prato 2</button>
			<td />
		</tr>
		<tr>
			<td>Peixe</td>
			<td>Arroz, feijão e batata frita</td>
			<td>12,00</td>
			<td><button type="submit" onclick="alert('Pedido Salvo')">
					Pedir prato 3</button>
			<td />
		</tr>

	</table>
	<div id="rodape"><jsp:include page="rodape.jsp"></jsp:include></div>
</body>
</html>