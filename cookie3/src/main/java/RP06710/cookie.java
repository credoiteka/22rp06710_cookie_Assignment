package RP06710;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookie2
 */
@WebServlet("/cookie2")
public class cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String storedUser = null;

	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("username")) {
	                    storedUser = cookie.getValue();
	                }
	            }
	        }

	        request.setAttribute("storedUser", storedUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("cookie.jsp");
	        dispatcher.forward(request, response);
	}
	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");

        // Create a cookie to store the username
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60*60*24*30); // 30 days
        response.addCookie(userCookie);

        // Redirect to the JSP page
        response.sendRedirect("cookie.jsp");
	}
	protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		   String userInput = request.getParameter("userInput");

	        // Create a cookie with the entered value
	        Cookie userCookie = new Cookie("savedUser", userInput);
	        userCookie.setMaxAge(60*60*24*365); // Cookie will last for one year
	        response.addCookie(userCookie);

	        // Redirect back to the form page
	        response.sendRedirect("cookie.html");
	    }

}
