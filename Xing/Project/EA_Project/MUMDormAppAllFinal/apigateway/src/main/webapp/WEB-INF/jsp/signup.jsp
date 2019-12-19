<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Signup</title>
	<link rel="stylesheet" href="../../resources/css/style.css" />
<%--	<link rel="stylesheet" href="../resource/style/signupStyle.css" />--%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/8fd24b2ea7.js"></script>
</head>
<body>
<div class="container bg-light">
	<h1>New SignUp</h1>
	<form:form modelAttribute="user" action="/users/create" method="post">

			<div class="form-group">
					<label class="col-sm-3 control-label">Username*</label>
					<div class="col-sm-9">
						<form:input path="userName" />
						<form:errors path="userName" />
					</div>

			</div>
			<div class="form-group">

					<label col-sm-3 control-label>Email</label>
					<div class="col-sm-9">
						<form:input path="email" />
						${msg}<form:errors path="email" />
					</div>

			</div>
		<div class="form-group">

			<label col-sm-3 control-label>Password</label>
			<div class="col-sm-4">
				<form:password path="password" />
				<form:errors path="password" />
			</div>

		</div>

			<div class="form-group">

					<label col-sm-3 control-label>Address</label>
					<div class="col-sm-9">
						<form:input path="addr.address" />
						<form:errors path="addr.address" />
					</div>

			</div>
			<div class="form-group">

					<label col-sm-3 control-label>Dorm Number</label>
					<div class="col-sm-9">
						<form:input path="addr.dormNumber" />
						<form:errors path="addr.dormNumber" />
					</div>

			</div>
			<div class="form-group">

				<label col-sm-3 control-label>Room Number</label>
					<div class="col-sm-9">
						<form:input path="addr.roomNumber" />
						<form:errors path="addr.roomNumber" />
					</div>

			</div>
		<button type="submit" class="btn btn-outline-success">Sign-Up</button>
	</form:form>
</div>
</body>

</html>