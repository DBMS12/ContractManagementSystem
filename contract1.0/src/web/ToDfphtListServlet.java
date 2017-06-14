package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.ConBusiModel;
import service.ContractService;
import utils.AppException;

/**
 * Servlet for accessing page of contract to be distributed 
 */
/**
 * Servlet implementation class ToDfphtListServlet
 */
@WebServlet("/ToDfphtListServlet")
public class ToDfphtListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDfphtListServlet() {
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
	 * Jump to page of contract to be distributed 
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set the request's character encoding
				request.setCharacterEncoding("UTF-8");
				
				// Declare session
				HttpSession session = null;
				// Get session by using request
				session = request.getSession();
				Integer userId = (Integer)session.getAttribute("userId");
				
				// If user is not login, jump to login page
				if (userId == null) {
					response.sendRedirect("toLogin");
				}else {
					
					try {
						// Initialize contractService
						ContractService contractService = new ContractService();
						// Initialize contractList
						List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();  
						// Call business logic layer to get list of contract to be distributed 
						contractList = contractService.getDfphtList();
						// Save contractList to request
						request.setAttribute("contractList", contractList);
						// Forward to contract to be distributed page
						request.getRequestDispatcher("/dfphtList.jsp").forward(request, response);
					} catch (AppException e) {
						e.printStackTrace();
						//Redirect to the exception page
						response.sendRedirect("toError");
					}
				}
	}

}
