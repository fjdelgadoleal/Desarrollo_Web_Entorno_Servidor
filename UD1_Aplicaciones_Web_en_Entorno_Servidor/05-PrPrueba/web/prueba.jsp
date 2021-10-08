<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="prueba.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prueba de página JSP</title>
</head>
<body>
Probando JSP en servidor...

<%
	Usuario usuario = new Usuario();
%>
Login: <%= usuario.getLogin() %>
Clave: <%= usuario.getClave() %>
<%out.println("Hola caracola..."); %>
</body>
</html>