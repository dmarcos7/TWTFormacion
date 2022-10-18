<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>Alta</title>
</head>
<body>

	<h1>Tienda Online</h1>
	<h4>Alta de un producto Nuevo</h4>



	<form action="altaProducto" method="post">
		<div class="mb-3">
			<label for="descripcion" class="form-label">Nombre Producto</label> 
			<input type="text" class="form-control" name="descripcion" placeholder="Producto">
		</div>
		<div class="mb-3">
			<label for="precioUnidad" class="form-label">Precio Producto</label> 
			<input type="number" steo="0.01" class="form-control" name="precioUnidad" placeholder="Precio">
		</div>

		<button type="submit" class="btn btn-primary">Insertar</button>


	</form>

	<div class="border border-warning">
		<!--  
<%@ page isELIgnored="false" %>   
-->
		${requestScope.errorBego}

	</div>




</body>
</html>