package service;

import com.alibaba.fastjson.JSONObject;

import dao.UserDao;
import entry.UserInfo;

public class Getopenid_stuInfoService {
	UserInfo info = new UserInfo();

	public JSONObject getStuinfo(String code) throws Exception {
		WeChatUserService service = new WeChatUserService();
		String wechat = service.cookie(code);
		JSONObject json = JSONObject.parseObject(wechat);
		String openid = json.getString("openid");
		System.out.println("µ÷ÓÃGetopenid_stuInfoService£¬openid£º"+openid);
		if (openid != null || "".equals(openid)) {
			UserDao dao = new UserDao();
			UserInfo userInfo = dao.searchUserByOpenid(openid);
			if (userInfo != null) {
				JSONObject UserInfo = new JSONObject();
				UserInfo.put("user_number", userInfo.getUser_number());
				UserInfo.put("user_password", userInfo.getUser_password());
				UserInfo.put("user_floor", userInfo.getUser_floor());
				UserInfo.put("user_identity", userInfo.getUser_identity());
				UserInfo.put("wx_check", userInfo.getWx_check());
				UserInfo.put("wx_name", userInfo.getWx_name());
				UserInfo.put("wx_img", userInfo.getWx_img());
				UserInfo.put("level", userInfo.getLevel());
				UserInfo.put("user_name", userInfo.getUser_name());
				return UserInfo;
			}
		}
		return null;
	}
}
