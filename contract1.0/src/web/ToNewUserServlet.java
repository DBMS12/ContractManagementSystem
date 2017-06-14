package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
 

/**
 * Servlet implementation class ToNewUserServlet
 */
@WebServlet("/ToNewUserServlet")
public class ToNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToNewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set request's character encoding
				request.setCharacterEncoding("UTF-8");
						
				// Declare session
				HttpSession session = null;
				// Get session by using request object
				session = request.getSession();
				Integer userId = (Integer)session.getAttribute("userId");
						
				// If user is not login, jump to login page
				if (userId == null) {
					response.sendRedirect("toLogin");
				}else {
					// Forward to new user page
					request.getRequestDispatcher("/newUser.jsp").forward(request, response);
				}
	}

}
