<%@page import="dao.UsuarioDAO"%>
<%@page import="entidades.EntidadUsuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Guardar Usuarios</h1>
	<a href="index.jsp">Regresar al menu</a>
	
	<form action="UsuarioServlet" method="post">
		<p><label>Nombres: </label></p><input type="text" name="nombres">
		<p><label>ApPaterno: </label></p><input type="text" name="appaterno">
		<p><label>ApMaterno: </label></p><input type="text" name="apmaterno">
		<p><label>Edad: </label></p><input type="text" name="edad">
		
		<button type="submit" name="action" value="guardar">Guardar</button>
	</form>
	
	<h3>Lista de Usuarios</h3>
	
	<table border="1">
		
		<tr>
			<th>ID</th>
			<th>Nombres</th>
			<th>ApPaterno</th>
			<th>ApMaterno</th>
			<th>Edad</th>
		</tr>
		
		<%
		
		List<EntidadUsuario> usuarios = (List<EntidadUsuario>)request.getAttribute("listUsuario");
		for(EntidadUsuario u : usuarios){
		%>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getNombres() %></td>
			<td><%= u.getAppaterno() %></td>
			<td><%= u.getApmaterno()%></td>
			<td><%= u.getEdad() %></td>
		</tr>
		
		<%
		}
		%>
	</table>
	
</body>
</html>