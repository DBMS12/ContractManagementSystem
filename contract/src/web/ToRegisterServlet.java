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
    	response.setContentType("text/html");//����������ݵ�����
		response.setCharacterEncoding("UTF-8");//����������ݵı���
		PrintWriter out = response.getWriter();//��ȡ�������
		//���ͷ������
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// Output the standard HTML structure
		out.println("<html>");
		out.println("<head>");
		// Set the character encoding for the HTML document
		out.println("<meta http-equiv='Content-Type' content='text/html' charset='utf-8' />");
		out.println("<title>ע��ҳ��</title>\r\n");
		out.println("</head>\r\n");
		out.println("<body>\r\n");
		//form ��
		out.println("<form action=\"register\" method=\"post\">\r\n");
		                           //��ת��registerҳ��            post�Ǽ��ܵġ�get���Կ������ĵ������
		out.println("��&nbsp;��&nbsp;���� <input type=\"text\" name=\"name\" /> <br />\r\n");
		out.println("��&nbsp;&nbsp;&nbsp;�룺\t<input type=\"password\" name=\"password\" /> <br />\r\n");
		out.println("�ظ����룺<input type=\"password\" name=\"password2\" /> <br />\r\n");
		out.println("<br />\r\n");
		
		out.println(request.getAttribute("message"));
		out.println("<input type=\"submit\" value=\"�ύ\" />\r\n");
		out.println("<form>\r\n");
		
		out.println("</body>");
		out.println("</html>");
		// Clear and close the output stream
		out.flush();
		out.close();

    }
}
