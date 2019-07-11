<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a cs544.Book</title>
</head>

<body>
	<c:if test="${msg == 'Update'}">
		<form action="../books/${book.id}" method="post">
	</c:if>
	<c:if test="${msg == 'Add'}">
		<form action="../books" method="post">
	</c:if>
	<table>
		<tr>
			<td>Make:</td>
			<td><input type="text" name="make" value="${book.title}" /> </td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><input type="text" name="model" value="${book.author}" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type="text" name="price" value="${book.price}" /> </td>
		</tr>
<%--		<tr>--%>
<%--			<td>Color:</td>--%>
<%--			<td><input type="text" name="color" value="${book.color}" /> </td>--%>
<%--		</tr>--%>
	</table>
	<input type="submit" value="${msg}"/>
	</form>
	<c:if test="${msg == 'Update'}">
		<form action="delete?bookId=${book.id}" method="post">
			<button type="submit">Delete</button>
		</form>
	</c:if>
</body>

</html>