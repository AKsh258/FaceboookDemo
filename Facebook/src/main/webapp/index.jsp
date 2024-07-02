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
		<%
			String l=request.getParameter("log");
			if(l!=null){
				%>
					<h1 class="position-absolute top-0 start-50 translate-middle-x text-warning p-5">You are successfully logged out !</h1>	
				<%
			}
		%>
		<div class="card text-bg--bs-info-rgb w-50 h-40">
			<div class="card-header fs-3"><img class="pe-3" alt="fblogo" src="image/facebook logo.png">Login</div>
			<div class="card-body">
				<form class="m-3" action="login" method="post">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email
							address</label> <input type="email" class="form-control"
							id="exampleInputEmail1" name="email" required>
						<div id="emailHelp" class="form-text">We'll never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label" >Password</label>
						<input type="password" class="form-control" id="exampleInputPassword1" name="password" required>
					</div>
					<div class="mb-2 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1" name="checkbox" required>
						<label class="form-check-label" for="exampleCheck1">Check me out</label>
					</div>
					<button type="submit" class="btn btn-primary w-100 mt-3">Submit</button>
						<a class="float-end text-decoration-none" href="RetrieveAccount.jsp">Forgot Password ?</a>
					<div class="d-flex justify-content-end align-items-center mt-4 pt-4">
					<p class="mt-3 d-flex text-info fw-bolder">If you have not registered yet so please </p>
					<a class="btn btn-primary text-cenetr ms-3" href="Register.jsp">Register</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
