package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
 
/**
 * Servlet for accessing contract operator page
 */
/**
 * Servlet implementation class ToOperatorServlet
 */
@WebServlet("/ToOperatorServlet")
public class ToOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * Process GET requests
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Call doPost() to process request
				this.doPost(request, response);
	}
	/**
	 * Jump to contract operator page
	 */
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
				
				// If the user is not login, then jump to login page
				if (userId == null) {
					response.sendRedirect("toLogin");
				}else {
					// Forward to the contract operator page
					request.getRequestDispatcher("/frame2.jsp").forward(request, response);
				}
	}

}
