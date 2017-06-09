package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.AppException;
import utils.DBUtil;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	
	//验证指定用户是否存在
		public boolean isExist(String name) throws AppException{
			Connection conn = null;//定义数据库连接对象
			PreparedStatement psmt = null;//定义预处理对象
			ResultSet rs = null;//定义结果集对象
			
			boolean flag = false;//操作标志
			try{
				conn = DBUtil.getConnection();//创建数据库连接
				//声明操作语句，根据用户名查询记录数，？为占位符
				String sql = "select id from t_user where name = ? and del = 0";
				
				psmt = conn.prepareStatement(sql);//预编译sql
				psmt.setString(1,name);//为占位符设置值
				
				rs = psmt.executeQuery();//执行查询，返回查询结果
				if(rs.next()){//判断结果集中是否优质
					flag = true;
				}
			}catch(SQLException e){
				e.printStackTrace();
				throw new AppException("dao.impl.UserDaoImpl.isExist");
			}finally{
				DBUtil.closeResultSet(rs);//关闭数据库查询结果集
				DBUtil.closeStatement(psmt);//关闭数据库预处理对象
				DBUtil.closeConnection(conn);//关闭数据库连接对象
			}
			return flag;
		}
	
		
		
	/*保存用户信息
	 * user 用户对象
     * return 保存成功返回true，否则返回false
	 * throws AppException
    */
	public boolean add(User user) throws AppException {
		// 声明操作标志flag
		boolean flag = false;
		//定义数据库操作对象
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			//创建数据库链接
			conn = DBUtil.getConnection();
			
			//定义SQL语句
			String sql = "insert into t_user(name,password)" + 
		             "values(?,?)";
			//预处理SQL语句
			psmt = conn.prepareStatement(sql);
			
			//设置参数
			psmt.setString(1,user.getName());
			psmt.setString(2,user.getPassword());
			
			//执行新增操作
			int result = -1;
			result = psmt.executeUpdate();
			//处理结果
			if(result > 0){
				flag = true;
			}			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.impl.UserDaoImpl.add");
		}finally{
			//关闭连接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);		
		}
		//返回结果	
		return false;	
	}
	
	
	
	
	/*根据用户名，密码查询用户编号
	 * name 用户名
	 * password 密码
	 * throws AppException
	 */
	public int login(String name,String password) throws AppException{
		int userId = -1;//初始化用户编号
		//声明数据库连接对象，预编译对象，和结果集对象
		Connection conn = null;//定义数据库连接对象
		PreparedStatement psmt = null;//定义预处理对象
		ResultSet rs = null;//定义结果集对象
		
		try{
			conn = DBUtil.getConnection();//创建数据库连接
			//声明操作语句，根据用户名查询用户编号，？为占位符
			String sql = "select id from t_user where name = ? and password = ? and del = 0";
			
			psmt = conn.prepareStatement(sql);//预编译sql
			psmt.setString(1,name);//为占位符设置值
			psmt.setString(2, password);
			
			rs = psmt.executeQuery();//执行查询，返回查询结果
			
			//查询到记录，提取用户编号	
			if(rs.next()){//判断结果集中是否优质
				userId = rs.getInt("id");
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("dao.impl.UserDaoImpl.login");
		}finally{
			DBUtil.closeResultSet(rs);//关闭数据库查询结果集
			DBUtil.closeStatement(psmt);//关闭数据库预处理对象
			DBUtil.closeConnection(conn);//关闭数据库连接对象
		}
		//返回用户编号
		return userId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
