package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ToRegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		// Forward to the registration page
		request.getRequestDispatcher("/register.jsp")
				.forward(request, response);
    }
}
