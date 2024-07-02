package com.files;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class PasswordStrength
 */
public class PasswordStrength extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public PasswordStrength() {
		super();
		// TODO Auto-generated constructor stub
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter pw = response.getWriter();
		String p = request.getParameter("password");

		int cupper = 0, clower = 0, cnum = 0, csp = 0;

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				clower++;
			else if (ch >= 'A' && ch <= 'Z')
				cupper++;
			else if (ch >= '0' && ch <= '9')
				cnum++;
			else
				csp++;
		}
		if (clower == 0 || cupper == 0 || cnum == 0 || csp == 0) {
			pw.print(
					"<h1 style='color:red;'>Password Should contain at least on of upper char lower char and number and special char</h1>");
			request.getRequestDispatcher("index.jsp").include(request, response);

		} else
			chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
