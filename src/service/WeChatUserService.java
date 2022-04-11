package service;

import com.alibaba.fastjson.JSONObject;

import dao.UserDao;

public class WeChatUserService {
	UserDao dao = new UserDao();

//	��¼
	public JSONObject login(String loginid, String loginpwd) {
		JSONObject student = dao.searchUserById(loginid);
		if (loginpwd.equals(student.getString("user_password"))) {
			return student;
		} else if (student.getString("msg") == null) {
			student.put("msg", "��������");
			return student;
		}
		return student;
	}

//	��ȡsessionid
	public String cookie(String code) {
		String sb = dao.getOppid(code);
		return sb;
	}

//	����openid
	public void upData(String old_openid, String openid, String user_number) {
		dao.upData(old_openid, openid, user_number);
	}

//	get_openid
	public JSONObject get_openid(String num, String openid) {
		try {
			JSONObject stu = dao.searchUserById(num);
			String opin = stu.getString("wx_openid");
			if (!opin.equals(openid)) {
				System.out.println("code�����ݿ��code��������������¼");
				return null;
			}
			return stu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
