<%@page import="java.util.Base64"%>
<%@page import="com.files.entities.UserDao"%>
<%@page import="com.files.entities.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete post</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
			<div class="card-header">Delete post</div>
			<div class="card-body">
				<div class="m-3" action="deletePost" method="post"
					enctype="multipart/form-data">
					<div class="mb-3">
						<span class="input-group-text"> Your Status : <%=p.getMessage()%>
						</span>
					</div>
					<div class="mb-3">
						<img id="image-preview"
							src="data:image/jpg;base64,<%=base64Image%>"
							class="card-img-top h-30 w-40" alt="...">
					</div>
					<p class="pt-3 text-danger">Are you sure want to delete this
						post ? please confirm</p>
					<div class="d-flex justify-content-between">
						<form action="deletePost" method="post">
							<input type="hidden" name="postid" value="<%=p.getPostid()%>">
							<input class="btn btn-danger" type="submit" value="Confirm Delete Post" onclick="alertSuccessfullorNot">
						</form>
						<a class="btn btn-primary" href="Home.jsp">Back to home page</a>
					</div>
				</div>
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
</body>
</html>