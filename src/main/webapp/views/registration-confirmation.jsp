<html>

<head>
	<title>Registration Confirmation</title>
</head>

<body>

	<h2>User registered successfully!</h2>
	 

	<hr>
	
	<a href="${pageContext.request.contextPath}/showMyLoginPage">Login with new user</a>
	<form:form action="${pageContext.request.contextPath }/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
	
</body>

</html>