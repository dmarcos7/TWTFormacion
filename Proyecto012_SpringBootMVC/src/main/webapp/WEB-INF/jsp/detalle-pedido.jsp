<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%><!-- formateado -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle pedido</title>
</head>
<body>
	<h2>Detalle Pedido</h2>
	Id:${pedido.id}
	<br>
	Descipcion: ${pedido.descripcion}
	<br>
	Fecha: <fm:formatDate value="${pedido.fechaPedido}" pattern="dd-MM-yyyy"/>
	<br>
	Entregado: ${pedido.entregado}
</body>
</html>