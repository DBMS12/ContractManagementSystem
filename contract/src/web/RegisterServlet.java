package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import service.UserService;
import model.User;


public class RegisterServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//设置字符集编码UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//获取注册信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		//实例化user，userService
		String message = "";
		User user = new User();
		UserService userService = new UserService;
		
		//验证
		//输出提示信息
		if(name == "" || password == "" || password2 == ""){
			System.out.println("注册信息不能为空");
		}else if(!password2.equals(password)){
			System.out.println("重复密码要与密码保持一致");
		}else{
			//System.out.println("——注册成功——");
			//System.out.println("用户名：" + name);
			//System.out.println("密码" + password);		

			try{
				//封装注册信息
				user.setNme(name);
				user.setPassword(password);
			
				//调用业务逻辑
				boolean flag = userService.register(user);
				if(flag){
					message = "注册成功！";
				}else{
					message = "注册失败";
				}
				
			} catch (AppException e){
				e.printStackTrace();
				//系统异常，提示
				message = "系统异常";
				}
			}
		
		//设置提示信息，将message信息保存到request中
		request.setAttribute("message", message);
		//跳转到注册页面
		request.getRequestDispatcher("toRegister").forward(request, response);
	}
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	doPost(request, response);

    }
}
