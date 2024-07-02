<%@page import="com.files.entities.UserDao"%>
<%@page import="java.util.Base64"%>
<%@page import="com.files.entities.Post"%>
<%@page import="com.files.entities.UserData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container d-flex justify-content-around align-items-center bg-dark">
<div class="container d-flex justify-content-around align-items-center h-100">

	<%
	
	Post m = (Post) session.getAttribute("mark");
	UserData u = (UserData) session.getAttribute("user");
	
	if (u != null) {
		byte[] img=u.getImage();
		
		String base64Image = Base64.getEncoder().encodeToString(img);
	%>
	
	<div class="card" style="width: 18rem;">

  		<img src="data:image/jpg;base64,<%=base64Image%>" class="card-img-top h-60 w-80" alt="...">
  		<div class="card-body">
    		<h5 class="card-title">name :<%=u.getName() %></h5>
    		<p class="card-text">Some quick example </p>
  		</div>
  	<ul class="list-group list-group-flush">
    <li class="list-group-item">Id : <%=u.getId() %> </li>
    <li class="list-group-item">Password : <%= u.getPassword()%></li>
    <li class="list-group-item">Email : <%=u.getEmail() %></li>
    <li class="list-group-item">Address : <%=u.getAddress() %></li>
    <li class="list-group-item">Marks</li>
    <li class="list-group-item">Hindi Marks : <%=u.getDate().getDate()%></li>
    <li class="list-group-item">Chemistry Marks : <%=u.getDate().getMonth()%> </li>
    <li class="list-group-item">English Marks :	<%=u.getDate().getHours()%> </li>
    <li class="list-group-item">Physics Marks : </li>
    <li class="list-group-item">Mathematics Marks : </li>
    <li class="list-group-item">Computer Marks : </li>
  	</ul>
  	<div class="card-body">
    	<a href="#" class="card-link text-decoration-none ms-3">Like</a>
    	<a href="#" class="card-link text-decoration-none ms-3">Comment</a>
    	<a class="card-link btn btn-primary text-cenetr ms-5" href="Home.jsp">Back</a>
  	</div>
	<%
		}
		else{		
	%>
		<div class="card text-bg--bs-info-rgb w-60 h-20">
			<h1>Session Expired please login again !</h1>
		</div>
		
	<%
		}
	%>	
	</div >

</div>

</body>
</html>