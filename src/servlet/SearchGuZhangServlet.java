package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import service.GuZhangService;

/**
 * Servlet implementation class SearchGuZhang
 */
@WebServlet("/SearchGuZhang")
public class SearchGuZhangServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); 
		String dsen = request.getQueryString();
		PrintWriter out = response.getWriter();
		GuZhangService service = new GuZhangService();
		if("".equals(dsen)) {
			ArrayList stus=  service.searchall();
			String json = JSON.toJSONString(stus, true);
//			System.out.println(json);
			out.print(json);
		}else{
			String ds = URLDecoder.decode(dsen, "utf-8");  
			ArrayList stus = service.searchByDs(ds);
			String json = JSON.toJSONString(stus, true);
//			System.out.println(json);
			out.print(json);
		}
		out.flush();
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
