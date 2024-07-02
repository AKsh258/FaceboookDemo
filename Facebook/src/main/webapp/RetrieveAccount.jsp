<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body
	class="container d-flex justify-content-around align-items-center bg-dark">
	
	<div
		class="container d-flex justify-content-around align-items-center h-100">
		<div class="card text-bg--bs-info-rgb w-50 h-70">
			<div class="card-header">Retrieve Account</div>
			<div class="card-body">
				<form class="m-3" action="retrieve" method="post">
					<div class="mb-3">
						<label for="na" class="form-label">Name</label> 
						<input type="text" class="form-control" id="na" placeholder="Abc" name="name">
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email address</label> 
						<input type="email" class="form-control" id="exampleInputEmail1" placeholder="abc@gmail.com" name="email">
					</div>
					<div class="mb-3">
						<label for="mob" class="form-label">Mobile No.</label> 
						<input type="number" class="form-control" id="mob" placeholder="8969XXXXXX" name="phone">
					</div>
					<button type="submit" class="btn btn-primary w-100 mt-5">Retrieve</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>