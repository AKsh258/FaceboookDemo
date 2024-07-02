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
import com.files.entities.UserData;

/**
 * Servlet implementation class NewPost
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPost() {
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
		Post p = new Post();
		HttpSession session = request.getSession();
		UserData ud = (UserData) session.getAttribute("user");
		System.out.println("out from new post servlet " + ud);
		if (ud != null) {
			p.setId(ud.getId());
			p.setMessage(request.getParameter("allmessage"));
			System.out.println("parameter all message : " + request.getParameter("allmessage"));
			Part part = request.getPart("file");
			InputStream inputStream = part.getInputStream();
			byte[] file = inputStream.readAllBytes();
			p.setPic(file);
			inputStream.close();
			int postData = UserDao.newPost(p);
			if (postData > 0) {
				pw.print("<h1>Record Saved Succesfull !</h1>");
			} else {
				pw.print("<h1>Record not Saved !</h1>");
			}	
			part.delete();
		} else {
			pw.print("<h1>Session Expired please login again !</h1>");
		}
	}
}
