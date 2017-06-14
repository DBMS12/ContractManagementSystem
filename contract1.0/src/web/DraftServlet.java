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
 * ��ݺ�ͬServlet 
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
	 * ���� POST��ʽ����ݺ�ͬҪ��
	 */
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����������ַ���Ϊ��UTF-8��
				request.setCharacterEncoding("UTF-8");
				
				// ���� session
				HttpSession session = null;
				//ʹ�� request�����ȡsession
				session = request.getSession();
				Integer userId = (Integer)session.getAttribute("userId");
				 
				// ����û�û�е�¼������ת����½����
				if (userId == null) {
					response.sendRedirect("toLogin");
				}else {
					// ��ȡ��ͬ��������Ϣ
					String name = request.getParameter("name");
					String customer = request.getParameter("customer");
					String content = request.getParameter("content");
					String beginTime = request.getParameter("beginTime");
					String endTime = request.getParameter("endTime");
					
					//  ʵ�廯 java.util.Date���͵�begin��end,��������ת����� beginTime and endTime
					Date begin = new Date();
					Date end = new Date();
					
		                        //����һ��������ʶflag1��������ʶ�����Ƿ�ת���ɹ�
		                          boolean flag1=false;
					// ����һ�����ڸ�ʽ���󣬽�String���͵�ʱ��ת��Ϊjava.util.Date��������
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
					
					try {
						begin = dateFormat.parse(beginTime);
						end = dateFormat.parse(endTime);
		                                flag1 = true; //ת���ɹ�
		                                } catch (ParseException e) {
		                                      e.printStackTrace();
		                                   }
						
		                         
		                         //��ʼ�� ��ʾ��Ϣ
					String message = "";
		                              
		                              //���ת���ɹ�������к�ͬ��ݲ��������򷵻����ҳ����ʾ������Ϣ
		                           if (flag1) {

						//  ����һ��Constract���󣬲�Ϊ�ö�������Ը�ֵ
						Contract contract = new Contract();
						contract.setName(name);
						contract.setCustomer(customer);
						contract.setBeginTime(begin);
						contract.setEndTime(end);
						contract.setContent(content);
						contract.setUserId(userId);
						
		                             try {
						
		                                //��ʼ����ͬҵ���߼���
						ContractService contractService = new ContractService();
						//����һ��������ʶflag2��������ʶ��ݺ�ͬ�Ƿ�ɹ�
		                                 boolean flag2 = false;
		                                 //����ҵ���߼�����ݺ�ͬ 
		                                 flag2 = contractService.draft(contract);
						// ����ʧ�ܻ��߳ɹ�,�������ҳ��, ������ʾ��Ϣ
						if (flag2) {
							message = "Drafting succeeded!";
							//�����δ����ĺ�ͬ��Ϣ���ݵ�ҳ������ʾ
							request.setAttribute("contract", contract);
						} else {
							message = "Drafting failure!";
						}
						// ���� message��request��
					request.setAttribute("message", message);
		                         
					// ת�������ҳ��
					request.getRequestDispatcher("/addContract.jsp").forward(request, response);
					}  catch (AppException e) {
						e.printStackTrace();
						//�ض����쳣ҳ��
						response.sendRedirect("toError");
						return;
					}
		           }
				}
					 
	}

}
