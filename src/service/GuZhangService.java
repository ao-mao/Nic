package service;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;

import dao.GuZhangDao;

public class GuZhangService {
	GuZhangDao dao = new GuZhangDao();
//	��ѯȫ��
	public ArrayList<?> searchall() {
		ArrayList<?> gzs = dao.searchAll();
		return gzs;
	}
//	��ѯĳһ��
	public ArrayList searchByDs(String ds) {
		ArrayList gzs = dao.searchByDs(ds);
		return gzs;
	}
//ɾ������
	public JSONObject delataGuZhang(String sb) {
		JSONObject json = JSONObject.parseObject(sb);
		String fault_id = json.getString("fault_id");
		String repair_id = json.getString("repair_id");
		int rs = dao.delate(repair_id, fault_id);
		JSONObject rsjson = new JSONObject();
//		1Ϊ�޸ĳɹ���0Ϊ�޸�ʧ�ܣ�2Ϊ��̨�������
		if(rs==0) {
			rsjson.put("msg","�޸�ʧ��");
		}else if(rs==1) {
			rsjson.put("rs","�޸ĳɹ�");
		}else {
			rsjson.put("msg","��̨��������");
		}
		return rsjson;
	}
//	0Ϊ�޸�ʧ�ܣ�1Ϊ�޸ĳɹ���2Ϊ��̨�������
	public JSONObject UpGuZhang(String faultcontent ,String userid ,String lh,String fh) {
		int rs = dao.UpGuZhang(faultcontent, userid, lh, fh);
		JSONObject rsjson = new JSONObject();
		if(rs==0) {
			rsjson.put("msg","�޸�ʧ��");
		}else if(rs==1) {
			rsjson.put("rs","�޸ĳɹ�");
		}else {
			rsjson.put("msg","��̨��������");
		}
		return rsjson;
	}
}
