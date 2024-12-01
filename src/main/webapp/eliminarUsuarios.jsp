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
	<h1>Eliminar Usuarios</h1>
	<a href="index.jsp">Regresar al menu</a>
	
	<form action="UsuarioServlet" method="post">
		<p><label>Id: </label></p><input type="text" name="id" id="idid" readonly>
		<p><label>Nombres: </label></p><input type="text" name="nombres" id="idnombres" readonly>
		<p><label>ApPaterno: </label></p><input type="text" name="appaterno" id="idappaterno" readonly>
		<p><label>ApMaterno: </label></p><input type="text" name="apmaterno" id="idapmaterno" readonly>
		<p><label>Edad: </label></p><input type="text" name="edad" id="idedad"> 
		 
		<button type="submit" name="action" value="eliminar">Eliminar</button>
	</form>
	
	<h3>Lista Usuarios</h3>
	<table border="1" id="mitabla">
		
		<tr>
			<th>ID</th>
			<th>Nombres</th>
			<th>ApPaterno</th>
			<th>ApMaterno</th>
			<th>Edad</th>
			<th>Accion</th>
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
			<td>
				<button type="submit" onclick="Seleccionar()">Seleccionar</button>
			</td>
		</tr>
		
		<%
		}
		%>
	</table>
</body>
</html>

<script>
	function Seleccionar(){
		var table = document.getElementById("mitabla");
		
		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function(){
				document.getElementById('idid').value = this.cells[0].innerHTML;
				document.getElementById('idnombres').value = this.cells[1].innerHTML;
				document.getElementById('idappaterno').value = this.cells[2].innerHTML;
				document.getElementById('idapmaterno').value = this.cells[3].innerHTML;
				document.getElementById('idedad').value = this.cells[4].innerHTML;
				

			}
		}
	}
</script>