<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery Login</title>
<style type="text/css">
#main {
	width: 1000px;
	padding: 0;
	margin-left: auto;
	margin-right: auto;
}

#header {
	height: 70px;
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

#cadastro {
	min-height: 300px;
	clear: both;
	border: 1px solid #CDCDCD;
	background-color: #CFF8FF;
	margin-bottom: 5px;
}

#lista {
	min-height: 100px;
	clear: both;
	border: 1px solid #CDCDCD;
	background-color: #C8F8FF;
	margin-bottom: 5px;
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
	<div id="header"><jsp:include page="header.jsp"></jsp:include></div>
	<div id="main">
		<div id="corpo">
			<div>
				<form name="Insert" action="UsuarioServlet">
					<input type="hidden" name="operacao" value="insert" />
					<table style="width: 100%">
						<tr align="center">
							<th>Nome</th>
							<th>CPF</th>
							<th>Telefone</th>
							<th>Endereço</th>
							<th>Inclusão</th>
						</tr>
						<tr align="center">
							<td><input type="text" name="nome" /></td>
							<td><input type="text" name="cpf" /></td>
							<td><input type="text" name="telefone" /></td>
							<td><input type="text" name="endereco" /></td>
							<td><input type="submit" value="Incluir" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="lista">
				<table style="width: 100%">
					<tr align="center">
						<th>Nome</th>
						<th>CPF</th>
						<th>Telefone</th>
						<th>Endereço</th>
						<th>Atualizar</th>
						<th>Excluir</th>
					</tr>
					<c:choose>
						<c:when test="${empty listaUsuarios}">
							<tr align="center">
								<td>Não há usuários</td>
							</tr>
						</c:when>
						<c:when test="${not empty listaUsuarios}">
							<c:forEach var="usuario" items="${listaUsuarios}">
								<tr align="center">
									<td>${usuario.nome}</td>
									<td>${usuario.cpf}</td>
									<td>${usuario.telefone}</td>
									<td>${usuario.endereco}</td>
									<td><input type="submit" value="Alterar" /></td>
									<td>
										<form name="Insert" action="UsuarioServlet">
											<input type="hidden" name="operacao" value="delete" />
											<input type="hidden" name="cpf" value="${usuario.cpf}" />
											<input type="submit" value="Excluir" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</table>
			</div>
		</div>
		<div id="rodape"><jsp:include page="rodape.jsp"></jsp:include></div>
	</div>
</body>
</html>
