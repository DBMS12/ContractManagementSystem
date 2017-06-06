package service;

import model.User;
import utils.AppException;

public class UserService {
	
	public boolean register(User user) throws AppExcception{
		boolean flag = false;
		//处理注册业务逻辑
		String existName = "jack";
		//验证不存在同名
		if(!user.getName().equals(existName)){
			//保存用户信息
			System.out.println("注册成功");//试验
			flag = true;
		}
		//返回flag
		return flag;
	}

}
