<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Date"%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Date: <%= new Date() %>
		<br/>
		
		<%
			String username = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
				for(Cookie cookie : cookies){
				    if(cookie.getName().equals("username")) 
				    	username = cookie.getValue();
				}
			}
				
			if (username != null) {
		%>
				You've reached this point from Login and your credentials are valid!<br/>
				<p>
					<a href="/LoginJSP/LogoutServlet">Logout</a>
				</p>
		<%
			}else{
		%>
				You aren't an identified user so you can try Login by clicking here: <br/><a href="/LoginJSP/login.jsp">Login</a>				
		<%  }%>
		
	</body>
</html>