package dao;

import utils.AppException;
import model.User;


public interface UserDao {

	//��ָ֤���û��Ƿ����
	public boolean isExist(String name) throws AppException;
	//�����û���Ϣ
	public boolean add(User user) throws AppException;
}
