<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
<h2>Lista de Pedidos del cliente ${usuario.nombre}!!!</h2>

<ul>
<c:forEach items="${listaPedidos}" var="pedido">

	<li>${pedido.id} - ${pedido.descripcion}</li>
	<a href="/pedido?idPedido=${pedido.id}">Ver Pedido</a>
	<a href="/pedido/borrar?idPedido=${pedido.id}">Eliminar</a>
</c:forEach>
</ul>
</body>
</html>