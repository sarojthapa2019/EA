<jsp:include page="index.jsp" />

<div class="container">
	<h1>User Detail:</h1>
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
			<tr>
				<td>${user.uid}</td>
				<td>${user.userName}</td>
				<td>${user.email}</td>
				<td>${user.addr.dormNumber}</td>
				<td>${user.addr.roomNumber}</td>
				<td>${user.addr.address}</td>
				<td><a href="users/update/${user.uid}">update</a></td>
			</tr>
	</table>
</div>
</body>

</html>