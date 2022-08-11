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
	
	<b><u>Listado de Ordenes de Despacho</u></b>
	
	<table>

		<tr>
			 
			<th><input type="text" name="filtroCodOrden"></th>
			<th><input type="text" name="filtroLogistica"></th>
			<th><input type="text" name="filtroCodVenta"></th>
			<th><input type="text" name="filtroPortal"></th>
			<th><input type="text" name="filtroArticulos"></th>
			<th><input type="text" name="filtroFecha"></th>
			
		</tr>
			
		<tr>
			<th>Codigo Orden</th>
			<th>Modulo Logistica</th>
			<th>Codigo Venta</th>
			<th>Modulo Portal</th>
			<th>Estado</th>
			<th>Solicitud Articulo</th>
			<th>Fecha</th>
		</tr>

		<c:forEach var="ordenes" items="${ordenes}">
			<tr>
				<td>${ordenes.codOrden}</td>
				<td>${ordenes.logistica}</td>
				<td>${ordenes.codVenta}</td> 
				<td>${ordenes.portal}</td> 
				<td>${ordenes.estado}</td>
				<td>${ordenes.articulos}</td> <!-- El articulo que se pidio -->
				<td>${ordenes.fecha}</td> <!-- La fecha en que se pidio el articulo -->
				<!-- ¿como muestro una lista dentro de una lista? -->
			</tr>
		</c:forEach>

	</table>

	<br>
	<a href="http://localhost:8080/DespachoTPOWeb/index.html"><input type=button value="Volver"></a>
</body>
</html>