<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>lista</title>
</head>
<body>

	<h1>Tienda Online</h1>
	<h4>Lista de un productos</h4>


	<%

	%>

	<ul>
		<c:forEach var="producto" items="${requestScope.lista}">
			
				<div class="col">
					<div class="card" style="width: 18rem;">

						<div class="card-body">
							<div class="bg-secondary text-white">
								<h5 class="card-title">${producto.idProducto}-${producto.descripcion}</h5>
							</div>

							<p class="card-text">${producto.precio}€</p>
						</div>
					</div>
				</div>
			
		</c:forEach>
	</ul>





</body>
</html>