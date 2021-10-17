<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Nominas!</h2>

	<form action="TodosLosEmpleados" method="post">
		<input class="boton" type="submit" value="Ver todos los empleados">
	</form>
	<br>
	<form action="SalarioEspecifico" method="post">
		Ver salario del empleado <input type="text" id="dni" name="dni">
		<input class="boton" type="submit" >
	</form>
	
	<br>
	<form action="ModificarEmpleado" method="post">
		Modificar el empleado con DNI: <input type="text" id="dni" name="dni">
		<input class="boton" type="submit">
	</form>

</body>
</html>
