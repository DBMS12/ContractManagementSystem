package service;

import model.User;
import utils.AppException;

public class UserService {
	
	public boolean register(User user) throws AppExcception{
		boolean flag = false;
		//����ע��ҵ���߼�
		String existName = "jack";
		//��֤������ͬ��
		if(!user.getName().equals(existName)){
			//�����û���Ϣ
			System.out.println("ע��ɹ�");//����
			flag = true;
		}
		//����flag
		return flag;
	}

}
