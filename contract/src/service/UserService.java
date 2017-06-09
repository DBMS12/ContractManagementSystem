package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import utils.AppException;

/*
 * *�û�ҵ���߼���
 */
public class UserService {
	
	private  UserDao userDao = null;//����һ��userDao�ӿڶ���
	/*
	 * �޲ι��췽��������ʼ��UserDaoʵ��
	 */
	public UserService(){
		userDao = new UserDaoImpl();
	}
	
	
	
	
	
	/*
	 * �û�ע��
	 * user �û�����
	 * return ע��ɹ�����true�����򷵻�false
	 * throws Appexception
	 */
	public boolean register(User user) throws AppException{
		boolean flag = false;//�����ʶ
		
		try{
			if(!userDao.isExist(user.getName())){//���û�������ʱ����ִ�б������
				flag = userDao.add(user);//������������ظ�flag
			}
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("servce.UserService.register");
		}
		
		//����flag
		return flag;
	}
	
	
	/*
	 * �����û���¼
	 * name �û���
	 * password ����
	 * return ����������ѯƥ����û���ţ����򷵻�0
	 * throws AppException
	 */
	public int login(String name,String password) throws AppException{
		int userId = -1;//�����û����
		try{
			//��ȡ�û����
			userId = userDao.login(name, password);
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("servce.UserService.login");
		}
		//�����û����
		return userId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
