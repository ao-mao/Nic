package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import sum.GetOpenidInf;
import sum.LoginInf;

/**
 * Servlet implementation class Get_openid
 */
@WebServlet("/Get_openid")
public class Get_openidServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			String code = request.getParameter("code");
			String num = request.getParameter("user_number");
			if (num != null && code != null) {
				LoginInf inf = new LoginInf();
				JSONObject stu = inf.getOpenid(code, num);
				if (stu == null) {
					out.print(false);
				} else {
					out.print(stu);
				}

			} else if (num == null  && code != null) {
				GetOpenidInf inf = new GetOpenidInf();
				JSONObject msg = inf.getopenid(code);
				if (msg != null) {
					HttpSession se = request.getSession();
					ServletContext application = se.getServletContext();
					String sid = (String) application.getAttribute("seesionid");
					if (sid != null) {
						JSONObject res = new JSONObject();
						res.put("SessionId", sid);
						res.put("msg", msg);
						res.put("success", "success");
						out.print(res);
					} else {
						out.print(false);
					}
				} else {
					out.print(false);
				}

			} else {
				out.print(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
