package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.edu.gdngs.ambms.CardChargeProxy;
import entry.StuInfo;
import entry.UserInfo;
import means.DbManager;
import service.AmbmsService;

public class XywUser {
	DbManager db = new DbManager();
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public StuInfo Search(String username, String num, String userid) {
		Connection con = db.getConnection("xyw", "root", "123456");
		StuInfo info = new StuInfo();
		String sql = "SELECT * FROM"
				+ "(SELECT b.room,a.className,b.username,b.xuehao,b.userid FROM `xyw_user_class` a LEFT JOIN xyw_user b ON a.xuehao = b.xuehao ) "
				+ "AS a INNER JOIN xyw_room b ON b.id = a.room  where a.username=? or a.xuehao=? or a.userid=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, num);
			pstm.setString(3, userid);
			System.out.println(username+"__"+num+"__"+userid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				String lh = rs.getString("lh");
				String fh = rs.getString("fh");
				String stu_name = rs.getString("username");
				String stu_idcard = rs.getString("userid");
				String stu_number = rs.getString("xuehao");
				String stu_major = rs.getString("className");
				String stu_room = lh + fh;
				AmbmsService service = new AmbmsService();
				String end_time = service.EndTime(stu_number);
				info = new StuInfo(stu_name, stu_idcard, stu_number, stu_major, stu_room, end_time);
//				return stuinfo;
			} else {
				info.setMsg("找不到此人");
			}

			return info;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.Clossall(con, pstm, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
//		public String EndTime(String id) throws Exception{
//			CardChargeProxy proxy = new CardChargeProxy();
//			String end_time = proxy.getUserLimitEndDate(id);
//			if(end_time!=null || !"".equals(end_time)) {
//				return end_time;
//			}else {
//				return null;
//			}
//		
//	}


}
