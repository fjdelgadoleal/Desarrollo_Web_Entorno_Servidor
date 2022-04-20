<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Empleados</title>
	<style>
        table {
        	border: 1px solid black;
        }
        td {
        	font-weight: bold;
        	background-color: black;
        	color: white;
        	width: 80px;
        	text-align: center;
        }
	</style>
</head>
<body>
	<h1>Lista de empleados</h1>

	<table>
		<tr>
			<td>Nombre</td>
			<td>DNI</td>
			<td>Sexo</td>
			<td>Categoría</td>
			<td>Años</td>
		</tr>
		<t:forEach var="emp" items="${listaEmp}">
			<tr>
				<td><t:out value="${emp.nombre}"></t:out></td>
				<td><t:out value="${emp.dni}"></t:out></td>
				<td><t:out value="${emp.sexo}"></t:out></td>
				<td><t:out value="${emp.categoria}"></t:out></td>
				<td><t:out value="${emp.anyos}"></t:out></td>
			</tr>
		</t:forEach>
	</table>
</body>
</html>