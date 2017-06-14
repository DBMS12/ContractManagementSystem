package service;

import java.util.ArrayList;
import java.util.List;

import dao.RightDao;
import dao.RoleDao;
import dao.UserDao;
import dao.impl.RightDaoImpl;
import dao.impl.RoleDaoImpl;
import dao.impl.UserDaoImpl;
import model.Role;
import model.User;
import utils.AppException;

/*
 * *用户业务逻辑类
 */
public class UserService {
	
	private  UserDao userDao = null;//定义一个userDao接口对象
	private RoleDao roleDao = null;// Define a roleDao interface object
	private RightDao rightDao = null;// Define a userDao rightDao object
	/*
	 * 无参构造方法用来初始化UserDao实例
	 */
	public UserService(){
		userDao = new UserDaoImpl();
		roleDao = new RoleDaoImpl();
		rightDao = new RightDaoImpl();
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
	
	
	/**
	 * Get the role information that corresponding to the user
	 * 
	 * @param userId 
	 * @return Role object
	 * @throws AppException
	 */
	public Role getUserRole(int userId) throws AppException {	
		Role role = null;// Declare role
		int roleId = -1; // Initialize  roleId
		try {
			//  Get the roleId that corresponding to the user
			roleId = rightDao.getRoleIdByUserId(userId);
			if(roleId > 0){
				// Get role information
				role = roleDao.getById(roleId); 
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("service.UserService.getUserRole");
		}
		return role;
	}
	
	/**
	 * Get user list that corresponding to the role
	 * 
	 * @param roleId 
	 * @return User list
	 * @throws AppException
	 */
	public List<User> getUserListByRoleId(int roleId) throws AppException {
		// Initialize  userList
		List<User> userList = new ArrayList<User>();
		// Declare userIds
		List<Integer> userIds = null; 
		
		try {
			/*
			 * 1.Get designated user's userIds
			 */
			userIds = rightDao.getUserIdsByRoleId(roleId);
			
			/*
			 * 2.Get user information list according to userIds
			 */ 
			for (int userId : userIds) {
				// Get user's information
				User user = userDao.getById(userId);
				if (user != null) {
					userList.add(user); 
				}
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("service.UserService.getUserList");
		}	
		// Return userList
		return userList;
	}
}
	
	
	
	
	
	
	
	
	
	


