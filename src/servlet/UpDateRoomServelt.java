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

import service.StuService;

/**
 * Servlet implementation class UpDateRoomServelt
 */
@WebServlet("/UpDateRoom")
public class UpDateRoomServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("xuehao");
		HttpSession se = request.getSession();
		ServletContext application = se.getServletContext();
		String sid = (String) application.getAttribute("seesionid");
		String cookie = request.getHeader("Cookie");
		String[] session = cookie.split("=");
		String JSESSIONID = session[1];
		if (JSESSIONID.equals(sid)) {
			StuService service = new StuService();		
			JSONObject rs = service.uproom(user_id);
			PrintWriter out = response.getWriter();
			out.print(rs);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
