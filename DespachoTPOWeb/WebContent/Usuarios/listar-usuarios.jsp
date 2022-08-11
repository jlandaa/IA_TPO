<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Usuarios</title>
</head>
<body>
	
	<%String estado; %>
	
	<b><u>Listado de Usuarios</u></b>

	<table>

		<tr>

			<th><input type="text" name="filtrouser"></th>
			<th><input type="text" name="filtronombre"></th>
			<th><input type="text" name="filtroapellido"></th>

		</tr>

		<tr>
			<th>Username</th>
			<th>Nombre</th>
			<th>Apellido</th>

			<c:forEach var="usuarios" items="${usuarios}">
				<tr>
					<td>${usuarios.username}</td>
					<td>${usuarios.nombre}</td>
					<td>${usuarios.apellido}</td>
					
					<% estado = "${usuarios.estado}"; 
						
					//Si esta activo
						if (estado == "true"){%>
							
							<!-- Se coloca una imagen para Habilitar/Deshabilitar
								 un Usuario 
							-->
							<td>
								<a href="http://localhost:8080/DespachoTPOWeb/GestionUsuarioServlet?user=${usuarios.username}">
									<img alt="Deshabilitar" src="Imagenes/deshabilitar.png">
								</a>
							</td>
					<%	
						}else{
					%>	
							<td>
								<a href="http://localhost:8080/DespachoTPOWeb/GestionUsuarioServlet?user=${usuarios.username}">
									<img alt="Deshabilitar" src="Imagenes/habilitar.png">
								</a>
							</td>		
					<%
						}
					%>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<br>
	<a href="http://localhost:8080/DespachoTPOWeb/index.html"><input type=button value="Volver"></a>
</body>
</html>