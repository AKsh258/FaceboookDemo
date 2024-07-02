package com.files;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.entities.UserDao;

/**
 * Servlet implementation class LikeCommentServlet
 */
public class LikeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try {
			
		
		System.out.println("this is like coment servlet ");
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println("User id : "+userid);
		
		String postid = request.getParameter("postid");
		System.out.println("Post id : "+postid);
		
		String comment = request.getParameter("comment");
		System.out.println("comment : "+comment);
		
		int commentPost = UserDao.commentPost(userid,postid,comment);
		if(commentPost>0) {
			System.out.println("comment updated");
			 String refreshTag = "<meta http-equiv=\"refresh\" content=\"0;url=Home.jsp\">";
	            request.setAttribute("refreshTag", refreshTag);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}else {
			System.out.println("no comment ");
		}
		
		}catch(NumberFormatException n) {
			
			String userid = request.getParameter("userId");
			System.out.println("userid : "+userid);
			String postid = request.getParameter("postId");
			System.out.println("postid :  "+postid);
		}
		
	}

}
