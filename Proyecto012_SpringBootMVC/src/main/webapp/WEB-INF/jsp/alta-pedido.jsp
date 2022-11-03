<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Alta Pedido</title>
</head>
<body>
	<nav class="navbar navbar-dark navbar-expand-lg bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">TiendaSpring</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="/pedidos">Pedidos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h2>Alta Pedido</h2>
	<form:form action="altaPedido" method="post"
		modelAttribute="pedidoForm">
		<form:label path="descripcion">Descripcion</form:label>
		<form:input path="descripcion" />
		<form:errors path="descripcion" />
		<br />
		<form:button class="btn btn-primary">Pedir</form:button>
	</form:form>
</body>
</html>