<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Inicio</title>
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

	<h2>Bienvenido ${usuario.nombre}!!!!</h2>
	<p>Eres: ${usuario.rol}</p>
	<c:if test="${usuario.rol eq 'cliente' }">
		<a class ="btn btn-primary" href="pedidos">Listar mis Pedidos</a>
	</c:if>
	<c:if test="${usuario.rol eq 'admin' }">
		<a class="btn btn-primary" href="pedidos">Listar Todos los Pedidos</a>
	</c:if>
	<a class="btn btn-primary" href="altaPedido">Realizar Pedido</a>
</body>
</html>