<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Information of Student to be updated</h1>
	${msg }

	<form action="update" method="post" modelAttribute="student">

		Id : <input type="text" name="id" value="${id}" /><br />
	    Name : <input type="text" name="name" /><br /> 
		<input type="submit" name="submit" value="submit" /> <input type="reset" name="reset" value="Reset" /><br />
		<button
			onclick="location.href='http://localhost:9191/mvc-javaconfig/index.jsp'"
			type="button">Go Back</button>
	</form>
</body>
</html>