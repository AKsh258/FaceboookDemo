package com.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.entities.Comment;
import com.files.entities.Like;
import com.files.entities.UserDao;

/**
 * Servlet implementation class DeletePost
 */
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String postid = request.getParameter("postid");
		ArrayList<Comment> all_comments = UserDao.getAllComments();
		ArrayList<Integer> cmid = new ArrayList<Integer>();
		for(Comment c: all_comments) {
			if(c.getPostid().equals(postid))
			cmid.add(c.getCmid());	
		}
		ArrayList<Like> all_likes = UserDao.getAllLikes();
		ArrayList<Integer> likeid = new ArrayList<Integer>();
		for(Like l: all_likes) {
			if(l.getPostid().equals(postid))
			likeid.add(l.getLikeid());	
		}
		
		int deleteYourPost = UserDao.DeleteYourPost(postid,cmid,likeid);
		if(deleteYourPost>0) {
			pw.println("deleted succesfull");
		}else {
			pw.println("something went wrong");
		}
		
	}

}
