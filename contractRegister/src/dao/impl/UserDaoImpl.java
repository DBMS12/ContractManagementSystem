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

	
	//��ָ֤���û��Ƿ����
		public boolean isExist(String name) throws AppException{
			Connection conn = null;//�������ݿ����Ӷ���
			PreparedStatement psmt = null;//����Ԥ��������
			ResultSet rs = null;//������������
			
			boolean flag = false;//������־
			try{
				conn = DBUtil.getConnection();//�������ݿ�����
				//����������䣬�����û�����ѯ��¼������Ϊռλ��
				String sql = "select id from t_user where name = ? and del = 0";
				
				psmt = conn.prepareStatement(sql);//Ԥ����sql
				psmt.setString(1,name);//Ϊռλ������ֵ
				
				rs = psmt.executeQuery();//ִ�в�ѯ�����ز�ѯ���
				if(rs.next()){//�жϽ�������Ƿ�����
					flag = true;
				}
			}catch(SQLException e){
				e.printStackTrace();
				throw new AppException("dao.impl.UserDaoImpl.isExist");
			}finally{
				DBUtil.closeResultSet(rs);//�ر����ݿ��ѯ�����
				DBUtil.closeStatement(psmt);//�ر����ݿ�Ԥ��������
				DBUtil.closeConnection(conn);//�ر����ݿ����Ӷ���
			}
			return flag;
		}
	
	public boolean add(User user) throws AppException {
		// ����������־flag
		boolean flag = false;
		//�������ݿ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			//�������ݿ�����
			conn = DBUtil.getConnection();
			
			//����SQL���
			String sql = "insert into t_user(name,password)" + 
		             "values(?,?)";
			//Ԥ����SQL���
			psmt = conn.prepareStatement(sql);
			
			//���ò���
			psmt.setString(1,user.getName());
			psmt.setString(2,user.getPassword());
			
			//ִ����������
			int result = -1;
			result = psmt.executeUpdate();
			//�������
			if(result > 0){
				flag = true;
			}			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);		
		}
		//���ؽ��	
		return false;	
	}

}