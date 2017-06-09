package dao;

import utils.AppException;
import model.User;


public interface UserDao {

	/*��ָ֤���û��Ƿ����
	 * return ��ͬ���û�����true�����򷵻�false
	 * throws AppException
	 */
	public boolean isExist(String name) throws AppException;
	
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
	
	
}
