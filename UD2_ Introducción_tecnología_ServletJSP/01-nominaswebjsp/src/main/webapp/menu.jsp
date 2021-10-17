<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú</title>
</head>
<body>
	<h2 align="center">Inicio de sesión</h2>
	<form name="Enviar"
		action="${pageContext.request.contextPath}/PrincipalServlet?action=user"
		method="post">
		<input type="submit" value="Ver Empleados" name="nombeeee"/>
	</form>
		
	<form name="Enviar"
		action="${pageContext.request.contextPath}/PrincipalServlet?action=modify"
		method="post">
		<input type="submit" value="Modificar Empleados" />
	</form>
	<form name="Enviar"
		action="${pageContext.request.contextPath}/PrincipalServlet?action=salary"
		method="post">
		<input type="submit" value="Mostrar Salarios" />
	</form>
	
	
</body>
</html>