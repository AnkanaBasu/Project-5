<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>This is the Student details</h2>
	<table height="50%" width="50%" align=center>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody align=center>
			<c:forEach items="${list}" var="st">
				<tr>
					<td><c:out value="${st.id}" /></td>
					<td><c:out value="${st.name}" /></td>
					<td><a type="button" class="btn btn-success" href="/mvc-javaconfig/update?id=<c:out value="${st.id}"/>">Update</a></td>
					<td><a type="button" class="btn btn-danger" href="/mvc-javaconfig/delete?id=<c:out value="${st.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
	
	<td><button
		onclick="location.href='http://localhost:9191/mvc-javaconfig/index.jsp'"
		type="button">Go Back</button></td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>