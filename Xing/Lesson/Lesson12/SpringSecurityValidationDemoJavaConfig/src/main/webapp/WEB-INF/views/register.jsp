<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a Car</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
</head>
<body>
<div class="container">
    <form:form modelAttribute="user">
        <table>
            <tr>
                <td>Username:</td>
                <td><form:input path="username"/></td>
                <td><form:errors path="username" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password"/></td>
                <td><form:errors path="password" cssClass="alert-danger" /> </td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><form:select path="authorities" itemLabel="name" itemValue="id" items="${authorities}"/></td>
            </tr>

        </table>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>