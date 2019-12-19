<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cars currently in the shop</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <sec:authorize access="isAuthenticated()">
            <p>Welcome Back, <sec:authentication property="name"/></p>
            <p><a href="logout">Logout</a></p>
        </sec:authorize>
    </div>
    <h1>Cars currently in the shop</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Make</th>
            <th scope="col">Model</th>
            <th scope="col">Year</th>
            <th scope="col">Color</th>
            <th scope="col">Operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.make}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.color}</td>
                <td><a href="cars/${car.id}">edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="addCar"> Add a Car</a>
</div>

</body>
</html>