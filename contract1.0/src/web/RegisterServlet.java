package web;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import service.UserService;
import utils.AppException;
import model.User;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集编码UTF-8
				request.setCharacterEncoding("UTF-8");
				
				//获取注册信息
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				//String password2 = request.getParameter("password2");
				
				//实例化user，userService
				boolean flag = false;
				String message = "";
				
				/*
				 * Call methods in business logic layer to process business logic 
				 */
				try {
					//Instantiate the object of entity class User  
					User user = new User();
					// Initialize the user business logic class
					UserService userService = new UserService();
					// Encapsulate the user information to the user object
					user.setName(name);
					user.setPassword(password);
					// Call business logic layer for user registration 
					flag = userService.register(user);
					if (flag) { // Registration Successful
						// After registration Successful, redirect to the login page
						response.sendRedirect("login.jsp");
					} else { // Registration failed
						// Set prompt message
						message = "Registration failed";
						request.setAttribute("message", message); // Save prompt message into request 
						// Forward to the registration page
						request.getRequestDispatcher("/register.jsp").forward(request,
								response);
					}
				} catch (AppException e) {
					e.printStackTrace();
					// Redirect to the exception page
					response.sendRedirect("toError");
				}
	}

}
