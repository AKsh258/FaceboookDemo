<%@page import="com.files.entities.UserData"%>
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
	class="container justify-content-around align-items-center bg-dark">

	<div
		class="container d-flex justify-content-around align-items-center h-100 m-5">
<%
UserData ud =(UserData)session.getAttribute("user");
if(ud!=null){
%>
		<div class="card text-bg--bs-info-rgb w-50 h-100">
			<div class="card-header">
				<img class="float-start" alt="fblogo" src="image/facebook logo.png">
				<p class="float-start ps-3 fs-3 fst-italic"><%=ud.getName()%></p>
				<form class="" action="logout" method="post">
   					 <input class="btn btn-danger text-cenetr float-end" type="submit" value="Logout" />
				</form>
			</div>
			<div class="card-header">New Post</div>
			<div class="card-body">
				<form class="m-3" action="newpost" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<span class="input-group-text"> What's on your mind ?</span>
						<textarea class="form-control h-40" placeholder="Write here " name="allmessage"></textarea>
					</div>
					<div class="mb-3">
						<img id="image-preview" src="" class="" alt="...">
						<input class="form-control" type="file" name="file" accept="image/*" onchange="previewImage(event)">
						
					</div>
					<button type="submit" class="btn btn-primary mt-5">post</button>
					<a class="btn btn-primary mt-5 float-end" href="Home.jsp">Back to home page</a>
				</form>
			</div>
		</div>
		<%}else{
			%>
			<div class="card text-bg--bs-info-rgb w-50 h-20">
				<h1>Session Expired ! please login again - </h1>
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
    </script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>