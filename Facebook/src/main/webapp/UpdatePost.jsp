<%@page import="com.files.entities.UserDao"%>
<%@page import="java.util.Base64"%>
<%@page import="com.files.entities.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Update post</title>
</head>
<body class="container">

	<%
	String postid = request.getParameter("postid");
	String name = request.getParameter("username");
	Post p = UserDao.getPostByID(postid);
	if (p != null) {

		session.setAttribute("userupdate", p);
		byte[] img = p.getPic();
		String base64Image = Base64.getEncoder().encodeToString(img);
	%>
	<div
		class="container d-flex justify-content-around align-items-center h-200 m-5">
		<div class="card text-bg--bs-info-rgb w-50 h-100">
			<div class="card-header ">
			<img class="float-start" alt="fblogo" src="image/facebook logo.png">
				<p class="float-start ps-3 fs-3 fst-italic"><%=name%></p>
				<form class="float-end" action="logout" method="post">
   					 <input class="btn btn-danger text-cenetr ms-3" type="submit" value="Logout" />
			</form>
			</div>
			<div class="card-header">Update Post</div>
			<div class="card-body">
				<form class="m-3" action="updatepost" method="post"
					enctype="multipart/form-data">
					<div class="mb-3">
						<span class="input-group-text"> What's on your mind ?</span>
						<textarea class="form-control h-100"
							placeholder="<%=p.getMessage()%>" name="allmessage"></textarea>
					</div>
					<div class="mb-3">
						<img id="image-preview"
							src="data:image/jpg;base64,<%=base64Image%>"
							class="card-img-top h-30 w-40" alt="..."> <input
							class="form-control" type="file" name="file" accept="image/*"
							onchange="previewImage(event)">

					</div>
					<button type="submit" class="btn btn-primary mt-5" onclick="alertSuccessfullorNot">Update
						Post</button>
					<a class="btn btn-primary mt-5 float-end" href="Home.jsp">Back to home page</a>
				</form>
			</div>
		</div>
		<%
		} else {
		%>
		<div class="card text-bg--bs-info-rgb w-50 h-20">
			<h1>Session Expired ! please login again -</h1>
		</div>
		<%
		}
		%>
	</div>
	<script>
		function previewImage(event) {
			const input = event.target;
			const preview = document.getElementById('image-preview');

			if (input.files && input.files[0]) {
				const reader = new FileReader();

				reader.onload = function(e) {
					preview.src = e.target.result;
				};

				reader.readAsDataURL(input.files[0]);
			} else {
				preview.src = ''; // Clear the image if no file is selected
			}
		}
		alertSuccessfullorNot = function() {
		        var alertMessage = '<%= request.getAttribute("alertMessage") %>';
		        if (alertMessage) {
		            alert(alertMessage);
		        }
		    };
	</script>

</body>
</html>