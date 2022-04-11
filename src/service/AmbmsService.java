package service;

import java.rmi.RemoteException;

import cn.edu.gdngs.ambms.CardChargeProxy;

public class AmbmsService {
	
	public String EndTime(String id) throws Exception{
		CardChargeProxy proxy = new CardChargeProxy();
		String end_time = proxy.getUserLimitEndDate(id);
		if(end_time!=null || !"".equals(end_time)) {
			return end_time;
		}else {
			return null;
		}
	}
}
        	