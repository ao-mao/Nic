package sum;

import com.alibaba.fastjson.JSONObject;

import service.WeChatUserService;

public class LoginInf {
	WeChatUserService service = new WeChatUserService();

//	login
	public JSONObject loginData(String id, String pwd, String code) {

		JSONObject userdata = service.login(id, pwd);
		if (userdata == null || userdata.get("msg") != null) {
			return userdata;
		}
		userdata.put("success", "登录成功");
		String wx = service.cookie(code);
		JSONObject json = JSONObject.parseObject(wx);
		String session_key = json.getString("session_key");
		String openid = json.getString("openid");
		String old_openid = userdata.getString("wx_openid");
//		System.out.println("验证code");
//		更新openid
		if (!openid.equals(old_openid)) {
			userdata.put("openid", openid);
			service.upData(old_openid, openid, id);
		}
		return userdata;

	}

//	get openid
	public JSONObject getOpenid(String code, String num) {
		if (num != " " || code != "") {
			String wx = service.cookie(code);
			JSONObject json = JSONObject.parseObject(wx);
			String openid = json.getString("openid");

			JSONObject user = service.get_openid(num, openid);
			return user;
		}
		return null;

	}
}
