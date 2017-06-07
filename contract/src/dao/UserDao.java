package dao;

import utils.AppException;
import model.User;


public interface UserDao {

	//验证指定用户是否存在
	public boolean isExist(String name) throws AppException;
	//保存用户信息
	public boolean add(User user) throws AppException;
}
