<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>

</head>

<body>

	<b><u>Listado de Articulos</u></b>

	<table>

		<tr>
		
			<th><input type="text" name="filtroCod"></th>
			<th><input type="text" name="filtroNombre"></th>
			<th><input type="text" name="filtroDeposito"></th>

		</tr>
		
		<tr>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Deposito</th>
		</tr>
		
		<c:forEach var="articulos" items="${articulos}">
			<tr>
				<td>${articulos.codigo}</td>
				<td>${articulos.nombre}</td>
				<td>${articulos.descripcion}</td>
				<td>${articulos.deposito}</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<br>
	<a href="http://localhost:8080/DespachoTPOWeb/index.html"><input type=button value="Volver"></a>
</body>
</html>