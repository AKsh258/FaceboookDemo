package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.files.entities.UserDao;
import com.files.entities.UserData;
import com.files.methods.OtpGenerate;

public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Retrieve() {
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("phone");
		System.out.println("name : "+name);
		System.out.println("Email : "+email);
		System.out.println("phone : "+mobile);
		UserData ud = UserDao.retriveRecords(name,email,mobile);
		System.out.println("Userr   :   :  "+ud);
		if(ud.getId()>0) {
			OtpGenerate og=new OtpGenerate();
			String otp = "Thanks for using Facebook";
			String msg=""+otp+"\n user id - "+email+"\nyour password is - "+ud.getPassword();
			og.sendMail(otp,email,msg);
			pw.print("<h1 style='color: green;'> Match Found and your id and password set to your mailbox please Login </h1>");
			request.getRequestDispatcher("index.jsp").include(request, response);
	
		}else {
			
			pw.print("<h1>User is not found</h1>");
		}
		
	}

}
