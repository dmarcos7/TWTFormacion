<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>

	<h2>Bienvenido ${usuario.nombre}!!!!</h2>
	<p>Eres: ${usuario.rol}</p>
	<c:if test="${usuario.rol eq 'cliente' }">
		<a href="pedidos">Listar mis Pedidos</a>
	</c:if>
	<c:if test="${usuario.rol eq 'admin' }">
		<a href="pedidos">Listar Todos los Pedidos</a>
	</c:if>
	<a href="altaPedido">Realizar Pedido</a>
</body>
</html>