package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ToAdminServlet
 */
@WebServlet("/ToAdminServlet")
public class ToAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Call doPost() to process request
				this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * Jump to Administrator page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set the request's character encoding
				request.setCharacterEncoding("UTF-8");
				
				// Declare session
				HttpSession session = null;
				// Get session by using request object
				session = request.getSession();
				Integer userId = (Integer)session.getAttribute("userId");
				
				// If the user is not logged in, then jump to the login page
				if (userId == null) {
					response.sendRedirect("toLogin");
				}else {
					// Forwarded to the contract administrator page
					request.getRequestDispatcher("/frame1.jsp").forward(request, response);
				}
	}

}
