package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import model.Contract;
import service.ContractService;
import utils.AppException;
/**
 * Servlet for draft contract
 */
/**
 * Servlet implementation class ToDraftServlet
 */
@WebServlet("/ToDraftServlet")
public class ToDraftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDraftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * Process the GET requests
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Call doPost() to process request
				doPost(request,response);
	}

	/**
	 * Process POST requests of draft contract
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Set the request's character encoding
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
					// Get contract data information
					String name = request.getParameter("name");
					String customer = request.getParameter("customer");
					String content = request.getParameter("content");
					String beginTime = request.getParameter("beginTime");
					String endTime = request.getParameter("endTime");
					
					// Instantiate begin and end of java.util.Date type,for accepting transformed beginTime and endTime
					Date begin = new Date();
					Date end = new Date();
					
					// Define a date format object, transform the time of String type into java.util.Date data type 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
					// Initialize prompt message
					String message = "";
					
					try {
						begin = dateFormat.parse(beginTime);
						end = dateFormat.parse(endTime);
						
						// Build a Contract object and assign value for the object's attribute
						Contract contract = new Contract();
						contract.setName(name);
						contract.setCustomer(customer);
						contract.setBeginTime(begin);
						contract.setEndTime(end);
						contract.setContent(content);
						contract.setUserId(userId);
						
						// Initialize contractService
						ContractService contractService = new ContractService();
						
						// Operation success or failure, return draft page, giving prompt message
						if (contractService.draft(contract)) {
							message = "Drafting succeeded!";
							// Transform the information created now to page for display
							request.setAttribute("contract", contract);
						} else {
							message = "Drafting failure!";
						}
						
					} catch (ParseException e) {
						e.printStackTrace();
						message = "Contract data is required. Incorrect date format";
					} catch (AppException e) {
						e.printStackTrace();
						//Redirect to the exception page
						response.sendRedirect("toError");
						return;
					}
					// Save message to request
					request.setAttribute("message", message);
					// Forward to draft page 
					request.getRequestDispatcher("/addContract.jsp").forward(request, response);
				}
	}

}
