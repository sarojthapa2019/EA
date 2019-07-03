<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customers</title>
</head>
<body>
	<h1>Customers:</h1>
	<ul>
		<c:forEach items="${customers}" var="customer">
			<li>${customer.name}</li>
		</c:forEach>
	</ul>
</body>
</html>
