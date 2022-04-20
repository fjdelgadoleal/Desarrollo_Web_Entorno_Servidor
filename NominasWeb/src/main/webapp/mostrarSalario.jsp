<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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
	<table>
		<tr>
			<td>DNI</td>
			<td>Salario</td>
		</tr>
		<tr>
			<td><t:out value="${emp.dni}"></t:out></td>
			<td><t:out value="${salario}"></t:out></td>
		</tr>
	</table>
</body>
</html>