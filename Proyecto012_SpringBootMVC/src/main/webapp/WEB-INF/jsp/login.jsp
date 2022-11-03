<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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

<title>Login</title>
</head>
<body>
	<h2>LOGIN</h2>

	<form:form action="login" method="post" modelAttribute="usuarioForm">
		<form:label path="nombre">Nombre Usuario:</form:label>
		<form:input path="nombre" />
		<form:errors path="nombre" />
		<br />
		<form:label path="clave">Clave</form:label>
		<form:password path="clave" />
		<form:errors path="clave" />
		<br />
		<form:button>Login</form:button>
	</form:form>
</body>
</html>