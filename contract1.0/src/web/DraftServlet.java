package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Contract;
import service.ContractService;
import utils.AppException;

/**
 * 起草合同Servlet 
 */
/**
 * Servlet implementation class DraftServlet
 */
@WebServlet("/DraftServlet")
public class DraftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * Process the GET requests
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Call doPost() to process request
				doPost(request,response);
	}

	/**
	 * 处理 POST方式的起草合同要求
	 */
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求的字符集为“UTF-8”
				request.setCharacterEncoding("UTF-8");
				
				// 声明 session
				HttpSession session = null;
				//使用 request对象获取session
				session = request.getSession();
				Integer userId = (Integer)session.getAttribute("userId");
				 
				// 如果用户没有登录，则跳转到登陆界面
				if (userId == null) {
					response.sendRedirect("toLogin");
				}else {
					// 获取合同的数据信息
					String name = request.getParameter("name");
					String customer = request.getParameter("customer");
					String content = request.getParameter("content");
					String beginTime = request.getParameter("beginTime");
					String endTime = request.getParameter("endTime");
					
					//  实体化 java.util.Date类型的begin和end,用来接收转换后的 beginTime and endTime
					Date begin = new Date();
					Date end = new Date();
					
		                        //定义一个操作标识flag1，用来标识日期是否转换成功
		                          boolean flag1=false;
					// 定义一个日期格式对象，将String类型的时间转换为java.util.Date数据类型
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
					
					try {
						begin = dateFormat.parse(beginTime);
						end = dateFormat.parse(endTime);
		                                flag1 = true; //转换成功
		                                } catch (ParseException e) {
		                                      e.printStackTrace();
		                                   }
						
		                         
		                         //初始化 提示信息
					String message = "";
		                              
		                              //如果转换成功，则进行合同起草操作，否则返回起草页面提示错误信息
		                           if (flag1) {

						//  创建一个Constract对象，并为该对象的属性赋值
						Contract contract = new Contract();
						contract.setName(name);
						contract.setCustomer(customer);
						contract.setBeginTime(begin);
						contract.setEndTime(end);
						contract.setContent(content);
						contract.setUserId(userId);
						
		                             try {
						
		                                //初始化合同业务逻辑类
						ContractService contractService = new ContractService();
						//定义一个操作标识flag2，用来标识起草合同是否成功
		                                 boolean flag2 = false;
		                                 //调用业务逻辑层起草合同 
		                                 flag2 = contractService.draft(contract);
						// 操作失败或者成功,返回起草页面, 给出提示信息
						if (flag2) {
							message = "Drafting succeeded!";
							//将本次创建的合同信息传递到页面上显示
							request.setAttribute("contract", contract);
						} else {
							message = "Drafting failure!";
						}
						// 保存 message到request里
					request.setAttribute("message", message);
		                         
					// 转发到起草页面
					request.getRequestDispatcher("/addContract.jsp").forward(request, response);
					}  catch (AppException e) {
						e.printStackTrace();
						//重定向到异常页面
						response.sendRedirect("toError");
						return;
					}
		           }
				}
					 
	}

}
