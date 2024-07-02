package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.files.entities.UserDao;
import com.files.entities.UserData;

public class VarifyOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VarifyOtp() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		UserData ud = (UserData)session.getAttribute("Userdata");
		String sentOtp = (String)session.getAttribute("sentOtp");
		
		String inputOtp = request.getParameter("inputOtp");	
		
		if(inputOtp.equals(sentOtp)) {
			int saveRecords =0;
			if(ud!=null) {
				saveRecords= UserDao.saveRecords(ud);
			}else {
				pw.print("<h1>Session out please register again </h1>");
				request.getRequestDispatcher("Register.jsp").include(request, response);
			}
			
			if(saveRecords<=0) {
				pw.print("<h1>Duplicate Entry unable to saveRecord</h1>");
			}else {
				System.out.println("record saved succesfully");
				pw.print("<h1 style='color: green;'> Record Saved Successfully please login </h1>");
				request.getRequestDispatcher("index.jsp").include(request, response);	
			}
			
		}else {
			System.out.println("Encorrect otp");
			pw.print("<h1 style='color: red;'>Please Enter a Valid Otp !</h1>");
			request.getRequestDispatcher("VarifyOtp.jsp").include(request, response);
		}
		
		
	}

}
