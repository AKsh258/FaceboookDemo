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
<body class="container d-flex justify-content-around align-items-center bg-dark">
	<div class="container d-flex justify-content-around align-items-center h-100">
		<div class="card text-bg--bs-info-rgb w-30 h-20">
			<div class="card-header fs-3"><img class="pe-3" alt="fblogo" src="image/facebook logo.png">Verification</div>
			<div class="card-body">
				<form class="m-3" action="varifyOtp" method="post">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Enter OTP</label> 
						<input type="text" class="form-control" id="exampleInputEmail1" name="inputOtp" required>
						<div id="emailHelp" class="form-text">OTP has been sent on your email</div>
					</div>
					<button type="submit" class="btn btn-primary w-100 mt-3">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>