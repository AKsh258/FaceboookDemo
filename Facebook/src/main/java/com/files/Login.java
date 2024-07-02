package com.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.files.entities.Comment;
import com.files.entities.Like;
import com.files.entities.Post;
import com.files.entities.UserDao;
import com.files.entities.UserData;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String m = request.getParameter("email");
		String p = request.getParameter("password");
		
		UserData u = UserDao.checkLogin(m, p);
		
		if(u.getId()>0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", u);
			
			response.sendRedirect("Home.jsp");
		}
		else {
				pw.print("<h1>Either id or password are incorrect </h1><h1>Please try again !! </h1>");
		}
		
	}

}
