<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="prueba.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Usuario usuario2 = new Usuario("javi", "javi"); %>
Usuario2:
</br>Login: <%=usuario2.getLogin() %>
</br>Pwd: <%=usuario2.getClave() %>
</body>
</html>