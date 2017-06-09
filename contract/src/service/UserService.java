package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import utils.AppException;

/*
 * *用户业务逻辑类
 */
public class UserService {
	
	private  UserDao userDao = null;//定义一个userDao接口对象
	/*
	 * 无参构造方法用来初始化UserDao实例
	 */
	public UserService(){
		userDao = new UserDaoImpl();
	}
	
	
	
	
	
	/*
	 * 用户注册
	 * user 用户对象
	 * return 注册成功返回true，否则返回false
	 * throws Appexception
	 */
	public boolean register(User user) throws AppException{
		boolean flag = false;//定义标识
		
		try{
			if(!userDao.isExist(user.getName())){//当用户不存在时可以执行保存操作
				flag = userDao.add(user);//将操作结果返回给flag
			}
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("servce.UserService.register");
		}
		
		//返回flag
		return flag;
	}
	
	
	/*
	 * 进行用户登录
	 * name 用户名
	 * password 密码
	 * return 根据条件查询匹配的用户编号，否则返回0
	 * throws AppException
	 */
	public int login(String name,String password) throws AppException{
		int userId = -1;//声明用户编号
		try{
			//获取用户编号
			userId = userDao.login(name, password);
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("servce.UserService.login");
		}
		//返回用户编号
		return userId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
