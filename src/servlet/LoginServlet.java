package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import sum.LoginInf;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
//		用户登录的信息
		String userId = request.getParameter("xuehao");
		String userPwd = request.getParameter("password");
		String code = request.getParameter("code");
		if(code!=null && userId !=null && userPwd!=null) {
				LoginInf inf = new LoginInf();
				JSONObject userdata = inf.loginData(userId, userPwd, code);
				if(userdata.get("success") != null){
					HttpSession session = request.getSession();
					request.getSession(true);
					String seesionid = session.getId();
					userdata.put("SessionId", seesionid);
				    ServletContext application = session.getServletContext(); 
				    application.setAttribute("seesionid", seesionid);
				    out.print(userdata);
				}else {	
					out.print(userdata);
				}
				
			
		}else
	
		out.flush();
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

