<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/login.css" rel='stylesheet' type='text/css' />
	<title>Sign in</title>
</head>
<body>
	<%
		String err = "";
		if (request.getAttribute("err") != null) {
			err = (String) request.getAttribute("err");
		}
	%>
	
	<div class="login-01">
		<div class="one-login  hvr-float-shadow">
			<div class="one-login-head">
				<img src="images/top-lock.png" alt="" />
				<h1>LOGIN</h1>
				
				<span></span>
			</div>
			<form action="LoginServlet" method="post">
				<% String mess="";
				if (request.getAttribute("mess") != null){
					mess= (String) request.getAttribute("mess");%>
				<li style="color: red"><%=mess%></li>	
					<% }%>
				<li style="color: red"><%=err%></li>
				Username
				<li><input type="text" class="text" value=""
					name="username"><a href="#" class=" icon user"></a></li>
				Password
				<li><input type="password" value=""
					name="password"><a href="#" class=" icon lock"></a></li>
				<div class="p-container">
					<label class="checkbox"><input type="checkbox"
						name="checkbox" checked><i></i>Remind password</label>
					<div class="clear"></div>
				</div>
				<div class="submit">
					<input type="submit" value="SIGN IN">
				</div>
			</form>
		</div>
	</div>

</body>
</html>