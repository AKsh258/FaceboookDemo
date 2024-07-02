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

import com.files.entities.UserDao;
import com.files.entities.UserData;

/**
 * Servlet implementation class register
 */
@MultipartConfig
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		UserData ud=new UserData();
		
		ud.setId(Integer.parseInt(request.getParameter("id")));
		ud.setName(request.getParameter("name"));
		ud.setAddress(request.getParameter("address"));
		ud.setPassword(request.getParameter("password"));
		ud.setEmail(request.getParameter("email"));
		ud.setMobile(Long.parseLong(request.getParameter("phone")));
		Part part = request.getPart("file");
		InputStream inputStream = part.getInputStream();
		byte[] file = inputStream.readAllBytes();
		inputStream.close();
		ud.setImage(file);
		
		String sentotp = (String)request.getAttribute("myotp");
		HttpSession session = request.getSession();
		session.setAttribute("Userdata", ud);
		session.setAttribute("sentOtp",	sentotp);
		response.sendRedirect("VarifyOtp.jsp");
	
	}
}
