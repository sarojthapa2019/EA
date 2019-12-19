<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="index.jsp" />

<div class="container">
	<h1>Update Detail:</h1>

	<form:form modelAttribute="user" action="/users/modify/${user.uid}" method="post">
		<form:errors path="*" element="div" cssClass="error"/>
		<table >
			<tr>
			<td>User Id</td><td><form:input path="uid" /></td>
			</tr>
			<tr>
			<td>User Name</td><td><form:input path="userName" /></td>
			</tr>
			<tr>
			<td>Email</td><td><form:input path="email" /></td>
			</tr>
			<tr>
			<td>Dorm Number</td><td><form:input path="addr.dormNumber" /></td>
			</tr>
			<tr>
			<td>Room Number</td><td><form:input path="addr.roomNumber" /></td>
			</tr>
			<tr>
			<td>Address</td><td><form:input path="addr.address" /></td>
			</tr>
			<tr>
			<td>Operation</td>
			</tr>
		</table>
		<button type="submit" class="btn btn-secondary">save</button>
</form:form>


<form action="/users/remove/${user.uid}" method="get">
		<button type="submit" class="btn btn-secondary">Delete</button>
	</form>

</div>
</body>
</html>