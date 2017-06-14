package dao;

import utils.AppException;
import model.User;

/**
 * 用户数据连接层接口
 */
public interface UserDao {

	/*验证指定用户是否存在
	 * return 有同名用户返回true，否则返回false
	 * throws AppException
	 */
	public boolean isExist(String name) throws AppException;
	/*验证指定用户是否存在
	 * return 有同名用户返回true，否则返回false
	 * throws AppException
	 */
	public boolean isExist(int id) throws AppException;
	

	
	/*保存用户信息
	 * user 用户对象
	 * return 保存成功返回true，否则返回false
	 * throws AppException
	 */
	public boolean add(User user) throws AppException;
	
	/*根据用户名，密码查询用户编号
	 * name 用户名
	 * password 密码
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
