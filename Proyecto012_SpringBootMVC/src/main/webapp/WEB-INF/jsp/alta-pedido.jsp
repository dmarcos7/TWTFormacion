<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Pedido</title>
</head>
<body>
	<h2>Alta Pedido</h2>
	<form:form action="altaPedido" method="post"
		modelAttribute="pedidoForm">
		<form:label path="descripcion">Descripcion</form:label>
		<form:input path="descripcion" />
		<form:errors path="descripcion" />
		<br />
		<form:button>Pedir</form:button>
	</form:form>
</body>
</html>