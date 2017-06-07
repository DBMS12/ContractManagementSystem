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

}
