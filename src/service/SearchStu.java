package service;

import java.rmi.RemoteException;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import dao.XywUser;
import entry.StuInfo;

public class SearchStu {
	XywUser user = new XywUser();
	AmbmsService service = new AmbmsService();
//	1�����ܲ鵽ѧ����Ϣ��0����鲻��ѧ����Ϣ
	public StuInfo search(String content) throws Exception {
		StuInfo stuinfo = user.Search(content, content, content);
		if(stuinfo.getStu_name()!=null || !"".equals(stuinfo.getStu_name())) {
			return stuinfo;
		}
		return null;
	}

}
