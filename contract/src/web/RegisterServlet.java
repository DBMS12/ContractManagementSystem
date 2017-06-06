package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import service.UserService;
import model.User;


public class RegisterServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//�����ַ�������UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//��ȡע����Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		//ʵ����user��userService
		String message = "";
		User user = new User();
		UserService userService = new UserService;
		
		//��֤
		//�����ʾ��Ϣ
		if(name == "" || password == "" || password2 == ""){
			System.out.println("ע����Ϣ����Ϊ��");
		}else if(!password2.equals(password)){
			System.out.println("�ظ�����Ҫ�����뱣��һ��");
		}else{
			//System.out.println("����ע��ɹ�����");
			//System.out.println("�û�����" + name);
			//System.out.println("����" + password);		

			try{
				//��װע����Ϣ
				user.setNme(name);
				user.setPassword(password);
			
				//����ҵ���߼�
				boolean flag = userService.register(user);
				if(flag){
					message = "ע��ɹ���";
				}else{
					message = "ע��ʧ��";
				}
				
			} catch (AppException e){
				e.printStackTrace();
				//ϵͳ�쳣����ʾ
				message = "ϵͳ�쳣";
				}
			}
		
		//������ʾ��Ϣ����message��Ϣ���浽request��
		request.setAttribute("message", message);
		//��ת��ע��ҳ��
		request.getRequestDispatcher("toRegister").forward(request, response);
	}
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	doPost(request, response);

    }
}
