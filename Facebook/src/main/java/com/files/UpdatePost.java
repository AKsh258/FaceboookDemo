package com.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.files.entities.Post;
import com.files.entities.UserDao;

/**
 * Servlet implementation class UpdatePost
 */
@MultipartConfig
public class UpdatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePost() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		Post p = (Post) session.getAttribute("userupdate");
		String postid = p.getPostid();

		String msg = request.getParameter("allmessage");

		Part img = request.getPart("file");
		InputStream inputStream = img.getInputStream();
		byte[] readAllBytes = inputStream.readAllBytes();
		inputStream.close();

		int updatePost = UserDao.updatePost(postid, msg, readAllBytes);

		if (updatePost > 0) {
		    pw.write("<script>alert('Something went wrong !!');</script>");
		} else {
		    pw.write("<script>alert('Something went wrong !!');</script>");
		}
		img.delete();
	}

}
