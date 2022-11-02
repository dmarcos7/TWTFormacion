<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>LOGIN</h2>

<form:form action="login" method="post" modelAttribute="usuario">
	<form:label path="nombre">Nombre Usuario:</form:label>
	<form:input path="nombre" />
	<form:label path="clave">Clave</form:label>
	<form:input path="clave"/>
	<form:button>Login</form:button>
</form:form>
</body>
</html>