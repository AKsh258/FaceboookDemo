<%@page import="com.files.entities.UserDao"%>
<%@page import="com.files.entities.Like"%>
<%@page import="com.files.entities.Comment"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.files.entities.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.files.entities.UserData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>    
<meta charset="UTF-8">
<title>Facebook home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body >
	<div class="container">
	<%
	String ps=request.getParameter("page");
	int pg=0;
	if(ps!=null){ pg=Integer.parseInt(ps);	}
	else {pg=1;}
	int p=pg;
	int total=3;
	if(pg==1) pg--;
	else pg=(pg-1)*total;
	UserData u = (UserData) session.getAttribute("user");
	ArrayList<Post> post = UserDao.getAllPostedData(pg,total);
	String currentDate = new Timestamp(new Date().getTime()).toString();
	String[] split = currentDate.split(" ");
	String date = split[0];
	if (u != null&&post!=null) {
		
		byte[] img = u.getImage();
		String image = Base64.getEncoder().encodeToString(img);
	%>
	<nav class="navbar bg-body-tertiary ">
		<div class="container ">
			<a class="navbar-brand" href="#"><img alt="fblogo" src="image/facebook logo.png"></a> 
			<span>Date : <%=date%></span> 
			<a class="navbar-brand" href="NewPost.jsp">New Post</a>
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link active" href="UserProfile.jsp"><img src="data:image/jpg;base64,<%=image%>" alt="Profile.pic" width="50" height="45"></a></li>
				<li class="nav-item"><a class="nav-link active" href="UserProfile.jsp"><%=u.getName()%></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><%=u.getEmail()%></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><%=u.getAddress()%></a></li>
				<li class="nav-item"><a class="nav-link" aria-disabled="true"><%=u.getId()%></a></li>
			</ul>
			<form action="logout" method="post">
   					 <input class="btn btn-danger text-cenetr ms-3" type="submit" value="Logout" />
			</form>
		</div>
	</nav>
	<div class="">
		<div class="row d-flex flex-row">
			<%
			ArrayList<Comment> all_comments = UserDao.getAllComments();
			ArrayList<Like> all_likes = UserDao.getAllLikes();
			for (Post d : post) {
				byte[] img2 = d.getPic();
				String base64Image = Base64.getEncoder().encodeToString(img2);
			%>
			<div class="col-md-4 ">
				<div class="card mt-2 p-2" style="width: 24rem;">
				<div class="card-body">
						
						<%if (u.getId() == d.getId()) { %>
						<a class="card-link text-decoration-none ms-2" href="UpdatePost.jsp?postid=<%=d.getPostid()%>&username=<%=u.getName()%>">Update post</a> 
						<a class="card-link text-decoration-none ms-3" href="DeletePost.jsp?postid=<%=d.getPostid()%>&username=<%=u.getName()%>">Delete post</a>
						<%}%>
						</div>
					<img src="data:image/jpg;base64,<%=base64Image%>" class="card-img-top h-60 w-80" alt="...">
					<div class="card-body">
						<h5 class="card-title"><%=d.getId()%></h5>
						<p class="card-text">Status :<%=d.getMessage()%></p>
					</div>
					<div class="card-body">
						<a href="#" class="card-link text-decoration-none ms-2" onclick="likePost('<%=u.getId()%>', '<%=d.getPostid()%>')">Like</a>
						<%
						int like=0;
						for(Like l: all_likes){
							if(d.getPostid().equals(l.getPostid())){
								like++;
							}
						} %>
						<span class="badge bg-primary rounded-pill"><%=like%></span>
						<a href="#" class="card-link text-decoration-none ms-2" onclick="showCommentForm('<%=d.getPostid()%>')">Comment</a>
						<div class="mt-3" id="commentForm_<%=d.getPostid()%>" style="display: none;">
						<form action="likeCommentServlet" method="post">
							<input type="hidden" name="postid" value="<%=d.getPostid()%>" >
							<input type="hidden" name="userid" value="<%=u.getId()%>" >
							<div class=" overflow-auto" style="height: 100px">
							<ul style="list-style-type: none; padding: 0; margin: 0;">				
						<%for(Comment c: all_comments){
							if(d.getPostid().equals(c.getPostid())){
						%>
							 	<li style="padding: 10px; border-bottom: 1px solid #eee;"><a class="text-decoration-none me-5" href="Profile.jsp?userid=<%=c.getUserid()%>"><%=c.getUserid()%></a><%=c.getComments()%>  </li>
						<%
							}
						} %>
							</ul>
						</div>
							<textarea class="form-control " style="height: 50px" id="commentText_<%=d.getPostid()%>"
								name="comment" rows="3" cols="40"
								placeholder="Write your comment here" required></textarea><br> 
							<input class="btn btn-primary " type="submit" value="Submit Comment" style="float: right;" >
						</form>
						</div>
					</div>
					<div class="card-footer">
      					<small class="text-body-secondary">Post time : <%=d.getLastUpdated()%></small>
    				</div>
				</div>
			</div>
			<%
			}
			int count=UserDao.countRecords();
			int n=count/total;
			int x=n*total;
			if(x<count) n++;
		%>
		</div>
		<nav class="pt-5 d-flex justify-content-center " aria-label="Page navigation ">
 		 <ul class="pagination">
 		 <%
 		 int prepage=1;
 		 if(p!=1) prepage=p-1; %>
 		 	<li class="page-item"><a class="page-link" href="Home.jsp?page=<%=1%>">Start</a></li>
 		 	 <li class="page-item"><a class="page-link" href="Home.jsp?page=<%=prepage%>">Previous</a></li>
 		 	 	<%
				for(int i=1; i<=n; i++){
				%>
 		 	 	<li class="page-item"><a class="page-link" href="Home.jsp?page=<%=i%>"><%=i%></a></li>
				<%
				}
 		 	 	int nextpage=p;
 		 		 if(p<n) nextpage=p+1;
				%>
				<li class="page-item"><a class="page-link" href="Home.jsp?page=<%=nextpage%>">Next</a></li>
				<li class="page-item"><a class="page-link" href="Home.jsp?page=<%=n%>">Last</a></li>
			</ul>
			<ul class="pagination ps-2">
					<li class="page-item"><p class="page-link bg-info text-dark fw-bolder"><%=p%> / <%=n%></p></li>
			</ul>
			</nav>
		</div>
	</div>	
	<%
	}else {
	%><div class="container bg-dark">
		<h1 class="text-warning p-5">You have logged out please login first !! </h1>
		<jsp:include page="index.jsp"></jsp:include>
	</div>
    <%
	} 
	%>	
	
	<script>
	function showCommentForm(postId) {
	    var commentForm = document.getElementById('commentForm_' + postId);
	    if (commentForm.style.display === 'none') {
	        commentForm.style.display = 'block';
	    } else {
	        commentForm.style.display = 'none';
	    }
	}
        function likePost(userId, postId) {
            // Create a new XMLHttpRequest object
            var xhr = new XMLHttpRequest();

            // Define the request parameters (method, URL, asynchronous)
            xhr.open('POST', 'likeCommentServlet', true);

            // Set the request header to specify the content type
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            // Define the data to be sent in the request body
            var data = 'userId=' + userId + '&postId=' + postId;

            // Set up a callback function to handle the response
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    // Handle the response if needed
                    console.log(xhr.responseText);
                }
            };

            // Send the request with the data
            xhr.send(data);
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>