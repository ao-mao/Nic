package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entry.UserInfo;
import means.DbManager;
import means.Time;

public class LogDao {
	DbManager db = new DbManager();
	Time time = new Time();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
//	查找网管信息
	public UserInfo searchUser(String user_name ) {
		Connection con = db.getConnection("fhy", "root", "123456");
		try {
			String sql = "select * from wx_users where user_name=? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user_name);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String user_number = rs.getString("user_number");
				UserInfo info = new UserInfo(user_number,user_name);
				return info;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				db.Clossall(con, pstm, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void UpLog(UserInfo info) {
		try {
		String login_time = time.getTime();
		Connection con = db.getConnection("lww", "root", "123456");
		String sql = "INSERT INTO wx_log VALUES (?,?,?,?,?,?)";
		pstm = con.prepareStatement(sql);	
		pstm.setString(1, info.getUser_name());
		pstm.setString(2, info.getUser_number());
		pstm.setString(3, login_time);
		pstm.setString(4, info.getIp());
		pstm.setString(5, info.getType());
		pstm.setString(6, info.getStuid());
		int i  = pstm.executeUpdate();
		if(i==1) {
			System.out.println("login_log");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
