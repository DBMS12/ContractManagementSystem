package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import service.UserService;
import utils.AppException;

public class LoginServlet extends HttpServlet{
	
	//����post��ʽ�ĵ�¼����
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//�����ַ�������UTF-8
		request.setCharacterEncoding("UTF-8");
				
		//��ȡע����Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		int userId = -1;
		
		//��ʼ����ʾ��Ϣ
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
				// Redirect to new user page
				response.sendRedirect("toNewUser");
			} else {// Login failed
				// Set prompt message
				message = "Incorrect user name or password!";
				request.setAttribute("message", message); // Save prompt message into request
				// Forward to login page
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// Redirect to exception page
			response.sendRedirect("toError");
		}
		
		
		
	}
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

    	doPost(request, response);
	}
}
