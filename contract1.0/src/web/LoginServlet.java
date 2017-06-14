package web;

import java.io.IOException;
 
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.Role;
import service.UserService;
import utils.AppException;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	//处理post方式的登录请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集编码UTF-8
				request.setCharacterEncoding("UTF-8");
						
				//获取注册信息
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				
				int userId = -1;
				
				//初始化提示信息
				String message = "";
				
				/*
				 * Call methods in business logic layer to process business logic 
				 */
				try {
					// Initialize the user business logic class
					UserService userService = new UserService();
					// Call business logic layer for user login
					userId = userService.login(name, password);
					if (userId > 0) { // Login successfully  
						// Declare session
						HttpSession session = null;
						// Get session by using request
						session = request.getSession();
						// Save userId and user name into session
						session.setAttribute("userId", userId);
						session.setAttribute("userName", name);
						// Declare role
						Role role = null;
						//Call business logic layer to get role's information
						role = userService.getUserRole(userId);
						
						// Process page jump according to the user's role
						if ( role == null) {
							//Redirect to new user page
							response.sendRedirect("toNewUser");
						} else if (role.getName().equals("admin")) {
							//Redirect to administrator page
							response.sendRedirect("toAdmin");
						} else if (role.getName().equals("operator")) {
							//Redirect to operator page 
							response.sendRedirect("toOperator");
						}
					} else {// Login failed
						// Set prompt message
						message = "Incorrect user name or password!";
						request.setAttribute("message", message); // Save prompt message into request
						// Save user name into request
						request.setAttribute("userName", name);	
						// Forward to login page
						request.getRequestDispatcher("/login.jsp").forward(request,	response);
					}
				} catch (AppException e) {
					e.printStackTrace();
					// Redirect to exception page
					response.sendRedirect("toError");
				}
				
				
	}

}
