package web;

import java.io.IOException;
 
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
 

/**
 * Servlet implementation class IndexServle
 */
@WebServlet("/IndexServle")
public class IndexServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
		}

}
