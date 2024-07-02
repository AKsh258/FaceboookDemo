package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpFilter;

import com.files.methods.OtpGenerate;

/**
 * Servlet Filter implementation class OtpVarificationfilter
 */
@MultipartConfig
public class OtpVarificationfilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public OtpVarificationfilter() {
       super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		System.out.println("Email : "+email );
		OtpGenerate og=new OtpGenerate();
		String otp = og.generateOtp();
		System.out.println("Otp : "+otp);
		
		String msg="Your otp for registration "+otp+" user id - "+email+"and your pass is - "+pass;
		
		boolean sendMail = og.sendMail(otp,email,msg);
		
		if(sendMail) {
			
			request.setAttribute("myotp", otp);
			
			chain.doFilter(request, response);
			
		}else {
			
			pw.print("<h1>Varification cod not send please check your email</h1>");
		}
		
		
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
