package sum;

import com.alibaba.fastjson.JSONObject;

import entry.StuInfo;
import service.SearchStu;

public class SearchStuInf {
	SearchStu service = new SearchStu();
	public JSONObject searchUserOnline(String content , String userid) throws Exception {
		StuInfo stuinf = service.search(content);
		if(stuinf.getStu_name()!=null || !"".equals(stuinf.getStu_name())) {
			JSONObject inf = new JSONObject();
			inf.put("stu_number", stuinf.getStu_number());
			inf.put("stu_idcard", stuinf.getStu_idcard());
			inf.put("stu_major", stuinf.getStu_major());
			inf.put("stu_name", stuinf.getStu_name());
			inf.put("stu_end_time", stuinf.getEnd_time());
			inf.put("stu_room", stuinf.getStu_room());
			return inf;
		}
		return null;
	}
}
