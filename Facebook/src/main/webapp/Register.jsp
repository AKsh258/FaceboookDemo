<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body
	class="container d-flex justify-content-around align-items-center bg-dark">
	
	<div
		class="container d-flex justify-content-around align-items-center h-100">
		<div class="card text-bg--bs-info-rgb w-50 h-70">
			<div class="card-header">Register</div>
			<div class="card-body">
				<form class="m-3" action="register" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="exam" class="form-label">Unique ID</label> 
						<input type="number" class="form-control" id="exam" placeholder="1XX2" name="id">
					</div>
					<div class="mb-3">
						<label for="na" class="form-label">Name</label> 
						<input type="text" class="form-control" id="na" placeholder="Abc" name="name">
					</div>
					<div class="mb-3">
						<label for="add" class="form-label">Address</label> 
						<input type="text" class="form-control" id="add" placeholder="Abc" name="address">
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Create Password</label>
						<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Abc@123" name="password">
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email address</label> 
						<input type="email" class="form-control" id="exampleInputEmail1" placeholder="abc@gmail.com" name="email">
					</div>
					<div class="mb-3">
						<label for="mob" class="form-label">Mobile No.</label> 
						<input type="number" class="form-control" id="mob" placeholder="8969XXXXXX" name="phone">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">We'll never share your data with anyone else.</label>
					</div>
					<div class="mb-3">
						<input class="form-control" type="file" name="file">
					</div>
					<button type="submit" class="btn btn-primary w-100 mt-5">Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>