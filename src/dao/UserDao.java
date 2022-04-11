package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;

import entry.UserInfo;
import means.DbManager;

public class UserDao {
	DbManager db = new DbManager();
	PreparedStatement pstm = null;
	ResultSet rs = null;
//	��֤��¼
	public JSONObject searchUserById(String loginid) {
		Connection con = db.getConnection("fhy","root","123456");
		try {
			String sql = "select * from Wx_users where user_number=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, loginid);
			rs = pstm.executeQuery();
			JSONObject stu = new JSONObject();
			if (rs.next()) {
				String user_password = rs.getString("user_password");
				String user_name = rs.getString("user_name");
				String user_number = rs.getString("user_number");
				String user_floor = rs.getString("user_floor");
				String user_identity = rs.getString("user_identity");
				String wx_name = rs.getString("wx_name");
				String wx_img = rs.getString("wx_img");
				String wx_openid = rs.getString("wx_openid");
				String wx_check = rs.getString("wx_check");
				int level = rs.getInt("level");

				stu.put("user_password", user_password);
				stu.put("user_name", user_name);
				stu.put("user_number", user_number);
				stu.put("user_floor", user_floor);
				stu.put("user_identity", user_identity);
				stu.put("wx_name", wx_name);
				stu.put("wx_img", wx_img);
				stu.put("wx_openid", wx_openid);
				stu.put("wx_check", wx_check);
				stu.put("level", level);
				return stu;
			} else {
				stu.put("msg", "�Ҳ�����");
				return stu;
			}
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

//��ȡsession_key��openid
	public String getOppid(String JSCODE) {
		BufferedReader in = null;
//		ƴװurl
		String AppId = "wxea4cb29d17165926";
		String AppSecret = "a19223f60f6889b8a63296fda439dacc";
		String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + AppId + "&secret=" + AppSecret
				+ "&js_code=" + JSCODE + "&grant_type=authorization_code";

		URL weChatUrl;
		try {
			weChatUrl = new URL(url);
			URLConnection connection = weChatUrl.openConnection();
			// ����ͨ�õ���������
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// ����ʵ�ʵ�����
			connection.connect();
			// ���� BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String sb = "";
//			��ȡ����
			String line;
			while ((line = in.readLine()) != null) {
				sb += line;
			}
			return sb;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

//����openid
	public void upData(String old_openid, String openid, String user_number) {
		Connection con = db.getConnection("fhy","root","123456");
		String sql = "UPDATE wx_users set wx_openid=? where user_number=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, openid);
			pstm.setString(2, user_number);
			int count = pstm.executeUpdate();

			if (count != 0) {
//				System.out.println("�ɹ�����code");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	��ѯ����
	public UserInfo searchUserByOpenid(String check_openid) {
		Connection con = db.getConnection("fhy", "root", "123456");
		try {
			System.out.println(check_openid);
			String sql = "select * from wx_users where wx_openid=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, check_openid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String user_name = rs.getString("user_name");
				String wx_check = rs.getString("wx_check");
				String user_number = rs.getString("user_number");
				String user_password = rs.getString("user_password");
				String user_floor = rs.getString("user_floor");
				String user_identity = rs.getString("user_identity");
				String openid = rs.getString("wx_openid");
				String wx_name = rs.getString("wx_name");
				String wx_img = rs.getString("wx_img");
				String level = rs.getString("level");
				UserInfo info = new UserInfo(user_number, user_password, user_floor, user_identity, openid,
						wx_img, wx_name, level, user_name,wx_check);
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
}
