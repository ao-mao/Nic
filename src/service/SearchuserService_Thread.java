package service;

import dao.LogDao;
import entry.UserInfo;

public class SearchuserService_Thread extends Thread{
	private String username;
	private String stuid;
	private String ip;
	public SearchuserService_Thread(String username,String stuid,String ip) {
		this.username = username ;
		this.stuid = stuid ;
		this.ip = ip ;
	}
	public void run() {
		LogDao dao = new LogDao();
		UserInfo userinfo = dao.searchUser(username);
		if(userinfo != null) {
			String type = "��ѯ";
			UserInfo loginfo = new UserInfo(userinfo.getUser_name(),userinfo.getUser_number(),ip,type,stuid) ;
			dao.UpLog(loginfo);
		}else {
			System.out.println("�Ҳ����û�");
		}
		
	}
}
