package entry;

public class UserInfo {
	String user_number;
	String user_password;
	String user_floor;
	String user_identity;
	String wx_check;

	String openid;
	String wx_name;
	String wx_img;
	String level;
	String user_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public UserInfo(String user_number, String user_password, String user_floor, String user_identity,
			String openid, String wx_name, String wx_img, String level, String user_name,String wx_check) {
		this.user_number = user_number;
		this.user_password = user_password;
		this.user_floor = user_floor;
		this.user_identity = user_identity;
		this.openid = openid;
		this.wx_name = wx_name;
		this.wx_img = wx_img;
		this.level = level;
		this.user_name = user_name;
		this.wx_check = wx_check;
	}

	public UserInfo() {

	}

	public String getUser_number() {
		return user_number;
	}

	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_floor() {
		return user_floor;
	}

	public void setUser_floor(String user_floor) {
		this.user_floor = user_floor;
	}

	public String getUser_identity() {
		return user_identity;
	}

	public void setUser_identity(String user_identity) {
		this.user_identity = user_identity;
	}
	
	public String getWx_check() {
		return wx_check;
	}

	public void setWx_check(String wx_check) {
		this.wx_check = wx_check;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getWx_name() {
		return wx_name;
	}

	public void setWx_name(String wx_name) {
		this.wx_name = wx_name;
	}

	public String getWx_img() {
		return wx_img;
	}

	public void setWx_img(String wx_img) {
		this.wx_img = wx_img;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
