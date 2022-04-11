package entry;

public class StuInfo {
	String stu_name;
	String stu_idcard;
	String stu_number;
	String stu_major;
	String stu_room;
	String msg;
	String end_time;
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public StuInfo(String stu_name, String stu_idcard,String stu_number,String stu_major,String stu_room,String end_time) {
		this.stu_name = stu_name;
		this.stu_idcard = stu_idcard;
		this.stu_number = stu_number;
		this.stu_major = stu_major;
		this.stu_room = stu_room;
		this.end_time = end_time;
	}
	public StuInfo(String end_time) {
		this.end_time = end_time;
	}
	public StuInfo() {
		
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_idcard() {
		return stu_idcard;
	}
	public void setStu_idcard(String stu_idcard) {
		this.stu_idcard = stu_idcard;
	}
	public String getStu_number() {
		return stu_number;
	}
	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}
	public String getStu_major() {
		return stu_major;
	}
	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}
	public String getStu_room() {
		return stu_room;
	}
	public void setStu_room(String stu_room) {
		this.stu_room = stu_room;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
