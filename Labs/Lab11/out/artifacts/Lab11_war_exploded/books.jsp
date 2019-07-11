<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books</title>
</head>
<body>
<h1>Books:</h1>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book.name}</li>
    </c:forEach>
</ul>
</body>
</html>