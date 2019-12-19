<jsp:include page="index.jsp" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
<h1>Current Users List</h1>

	<table border="1px">
		<thead>
			<td>User Id</td>
			<td>User Name</td>
			<td>Email</td>
			<td>Dorm Number</td>
			<td>Room Number</td>
			<td>Address</td>
			<td>Operation</td>
		</thead>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.uid}</td>
				<td>${user.userName}</td>
				<td>${user.email}</td>
				<td>${user.addr.dormNumber}</td>
				<td>${user.addr.roomNumber}</td>
				<td>${user.addr.address}</td>
				<td><a href="/users/modify/${user.uid}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>

</html>