<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.botones-container{
		text-align: center;
	}
	
	.botones-container button{
		margin: 5px;
	}
</style>

</head>
<body>
	<h1>CRUD JSP + MYSQL</h1>
	<h2>Menu Principal</h2>
	
	<div class="botones-container">
		<form action="UsuarioServlet" method="get">
			<button><a href="UsuarioServlet?action=mostrar" class="btn">Mostrar Usuarios</a></button> 
			<button><a href="UsuarioServlet?action=guardar">Guardar Usuarios</a></button>
			<button><a href="UsuarioServlet?action=modificar">Modificar Usuarios</a></button>
			<button><a href="UsuarioServlet?action=eliminar">Eliminar Usuarios</a></button>
		</form>
		

	</div>
	
</body>
</html>