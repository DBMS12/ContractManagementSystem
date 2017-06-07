package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
/*
 * 接受HTTP请求，进行处理并生成响应，然后把结果返回给客户端
 */
public class IndexServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// Output the standard HTML structure
		out.println("<html>");
		out.println("<head>");
		// Set the character encoding for the HTML document
		out.println("<meta http-equiv='Content-Type' content='text/html' charset='utf-8' />");
		out.println("<title>IndexServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Welcome to Contract Management System!");//Information in HTML Body
		out.println("</body>");
		out.println("</html>");
		// Clear and close the output stream
		out.flush();
		out.close();
	}

}
