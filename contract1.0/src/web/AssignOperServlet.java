package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import service.ContractService;
import utils.AppException;
import utils.Constant;

/**
 * Servlet implementation class AssignOperServlet
 */
@WebServlet("/AssignOperServlet")
public class AssignOperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignOperServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set the request's character encoding
				request.setCharacterEncoding("UTF-8");

				// Declare session
				HttpSession session = null;
				// Get session by using request
				session = request.getSession();
				Integer userId = (Integer) session.getAttribute("userId");

				// If user is not login, jump to login page
				if (userId == null) {
					response.sendRedirect("toLogin");
				} else {

					/*
					 * Get information of assign contract
					 */
					// Get Contract id
					int conId = Integer.parseInt(request.getParameter("conId"));
					// Get assigned cuntersign people's id
					String[] hqht = request.getParameterValues("hqht");
					// Get assigned approver's id
					String[] spht = request.getParameterValues("spht");
					// Get assigned signer's id
					String[] qdht = request.getParameterValues("qdht");

					try {
						// Initialize contractService
						ContractService contractService = new ContractService();
						/*
						 * Call business logic layer to distributed contract
						 */
						// Assigned cuntersign people
						for (String hq : hqht) {
							contractService.distribute(conId, Integer.parseInt(hq),
									Constant.PROCESS_CSIGN);
						}

						// Assigned approver
						for (String sp : spht) {
							contractService.distribute(conId, Integer.parseInt(sp),
									Constant.PROCESS_APPROVE);
						}

						// Assigned signer
						for (String qd : qdht) {
							contractService.distribute(conId, Integer.parseInt(qd),
									Constant.PROCESS_SIGN);
						}

						// After complete assignment,redirect to page of to be
						// distributed
						response.sendRedirect("toDfphtList");
					} catch (AppException e) {
						e.printStackTrace();
						// Redirect to exception page
						response.sendRedirect("toError");
					}
				}
	}

}
