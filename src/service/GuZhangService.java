package service;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;

import dao.GuZhangDao;

public class GuZhangService {
	GuZhangDao dao = new GuZhangDao();
//	查询全部
	public ArrayList<?> searchall() {
		ArrayList<?> gzs = dao.searchAll();
		return gzs;
	}
//	查询某一栋
	public ArrayList searchByDs(String ds) {
		ArrayList gzs = dao.searchByDs(ds);
		return gzs;
	}
//删除故障
	public JSONObject delataGuZhang(String sb) {
		JSONObject json = JSONObject.parseObject(sb);
		String fault_id = json.getString("fault_id");
		String repair_id = json.getString("repair_id");
		int rs = dao.delate(repair_id, fault_id);
		JSONObject rsjson = new JSONObject();
//		1为修改成功，0为修改失败，2为后台代码出错
		if(rs==0) {
			rsjson.put("msg","修改失败");
		}else if(rs==1) {
			rsjson.put("rs","修改成功");
		}else {
			rsjson.put("msg","后台出错，请检查");
		}
		return rsjson;
	}
//	0为修改失败，1为修改成功，2为后台代码出错
	public JSONObject UpGuZhang(String faultcontent ,String userid ,String lh,String fh) {
		int rs = dao.UpGuZhang(faultcontent, userid, lh, fh);
		JSONObject rsjson = new JSONObject();
		if(rs==0) {
			rsjson.put("msg","修改失败");
		}else if(rs==1) {
			rsjson.put("rs","修改成功");
		}else {
			rsjson.put("msg","后台出错，请检查");
		}
		return rsjson;
	}
}
