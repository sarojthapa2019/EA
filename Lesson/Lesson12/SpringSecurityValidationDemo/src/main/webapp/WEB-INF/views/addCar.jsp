<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Car</title>
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
    <form:form modelAttribute="car">
        <table>
            <tr>
                <td>Make:</td>
                <td><form:input path="make"/></td>
                <td><form:errors path="make" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>Model:</td>
                <td><form:input path="model"/></td>
                <td><form:errors path="model" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><form:input path="year"/></td>
                <td><form:errors path="year" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><form:input path="color"/></td>
                <td><form:errors path="color" cssClass="alert-danger" /> </td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>