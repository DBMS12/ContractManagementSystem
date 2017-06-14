package dao;

import utils.AppException;
import model.User;

/**
 * �û��������Ӳ�ӿ�
 */
public interface UserDao {

	/*��ָ֤���û��Ƿ����
	 * return ��ͬ���û�����true�����򷵻�false
	 * throws AppException
	 */
	public boolean isExist(String name) throws AppException;
	/*��ָ֤���û��Ƿ����
	 * return ��ͬ���û�����true�����򷵻�false
	 * throws AppException
	 */
	public boolean isExist(int id) throws AppException;
	

	
	/*�����û���Ϣ
	 * user �û�����
	 * return ����ɹ�����true�����򷵻�false
	 * throws AppException
	 */
	public boolean add(User user) throws AppException;
	
	/*�����û����������ѯ�û����
	 * name �û���
	 * password ����
	 * throws AppException
	 */
	public int login(String name,String password) throws AppException;
	
	/*
	 * Query user's information according to id
	 * 
	 * @param id  User id
	 * @return User 
	 * @throws AppException
	 */
	public User getById(int id) throws AppException;
	
	
}
