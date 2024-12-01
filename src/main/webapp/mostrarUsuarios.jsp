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
	<h1>Tabla de Usuarios</h1>
	<a href="index.jsp">Regresar al menu</a>
	
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