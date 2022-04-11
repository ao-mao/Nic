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
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import entry.UserInfo;
import jdbc.DbManager;

public class LoginDao {
	DbManager db = new DbManager();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	Connection con = db.getConnection("fhy", "root", "123456");

//	��֤��¼
/**	
	
	public Map<String, Comparable> login(String loginid, String loginpwd) {
//		System.out.println(loginid);
		String sql = "select * from Wx_users where user_number=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, loginid);
			rs = pstm.executeQuery();
			Map<String, Comparable> data = new HashMap();
			if (rs.next()) {
//				��ȡ���ݿ�����
				String user_password = rs.getString("user_password");
//				�û��������������ݿ������Ƿ�ƥ��
				if (loginpwd.equals(user_password)) {
					String user_name = rs.getString("user_name");
					String user_number = rs.getString("user_number");
					String user_floor = rs.getString("user_floor");
					int level = rs.getInt("level");
					String wx_name = rs.getString("wx_name");
//					String wx_img = rs.getString("wx_img");
//					String wx_openid = rs.getString("wx_openid");
					String user_identity = rs.getString("user_identity");

					data.put("user_name", user_name);
					data.put("user_number", user_number);
					data.put("user_password", user_password);
					data.put("user_floor", user_floor);
					data.put("level", Integer.valueOf(level));
					data.put("wx_name", wx_name);
					data.put("user_identity", user_identity);
					return data;
				} else {
					System.out.println("�������");
					data.put("msg", "�������");
					return data;
				}
			} else {
				System.out.println("�Ҳ�����");
				data.put("msg", "�û�������");
				return data;
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

	
//��ȡopenid
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
**/


}
