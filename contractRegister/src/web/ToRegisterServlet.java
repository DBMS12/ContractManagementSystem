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
    	response.setContentType("text/html");//设置输出内容的类型
		response.setCharacterEncoding("UTF-8");//设置输出内容的编码
		PrintWriter out = response.getWriter();//获取输出对象
		//输出头部声明
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// Output the standard HTML structure
		out.println("<html>");
		out.println("<head>");
		// Set the character encoding for the HTML document
		out.println("<meta http-equiv='Content-Type' content='text/html' charset='utf-8' />");
		out.println("<title>注册页面</title>\r\n");
		out.println("</head>\r\n");
		out.println("<body>\r\n");
		//form 表单
		out.println("<form action=\"register\" method=\"post\">\r\n");
		                           //跳转到register页面            post是加密的。get可以看到明文的密码等
		out.println("用&nbsp;户&nbsp;名： <input type=\"text\" name=\"name\" /> <br />\r\n");
		out.println("密&nbsp;&nbsp;&nbsp;码：\t<input type=\"password\" name=\"password\" /> <br />\r\n");
		out.println("重复密码：<input type=\"password\" name=\"password2\" /> <br />\r\n");
		out.println("<br />\r\n");
		
		out.println(request.getAttribute("message"));
		out.println("<input type=\"submit\" value=\"提交\" />\r\n");
		out.println("<form>\r\n");
		
		out.println("</body>");
		out.println("</html>");
		// Clear and close the output stream
		out.flush();
		out.close();

    }
}
