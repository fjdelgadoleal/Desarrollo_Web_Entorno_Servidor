<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar empleado</title>
</head>
<body>
	<h1>Buscar empleado</h1>
	
	<form action="controller?opcion=getSalario" method="POST">
  		<label for="dni">DNI del empleado: </label>
  		<input type="text" id="dni">
		<input type="submit" value="Buscar">
	</form>

</body>
</html>