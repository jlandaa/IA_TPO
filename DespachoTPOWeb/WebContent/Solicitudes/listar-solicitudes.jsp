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

	<b><u>Listado de Solicitudes</u></b>

	<table>

		<tr>

			<th><input type="text" name="filtroArticulos"></th>
			<th><input type="text" name="filtroRecibidos"></th>
			<th><input type="text" name="filtroSolicitados"></th>
			<th><input type="text" name="filtroEstado"></th>

		</tr>

		<tr>
			<th>Articulo</th>
			<th>Recibido</th>
			<th>Solicitado</th>
			<th>Estado</th>
		</tr>
		
		<c:forEach var="solicitudes" items="${solicitudes}">
			<tr>
				<td>${solicitudes.articulo.id}</td>
				<td>${solicitudes.recibidos}</td>
				<td>${solicitudes.solicitados}</td>
				<td>${solicitudes.estado}</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<br>
	<a href="http://localhost:8080/DespachoTPOWeb/index.html"><input type=button value="Volver"></a>
</body>
</html>