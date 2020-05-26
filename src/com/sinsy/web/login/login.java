package com.sinsy.web.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinsy.web.usersql.JDBC;
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		获取来自前端html页面的数据
		String nickname=request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		JDBC yu = new JDBC();
		HttpSession session =request.getSession();
		session.setAttribute("nickname", nickname);
		session.setAttribute("psswd",pwd);
		try {
			if(yu.inthetable("scx","userinfo", "nickname", nickname, pwd)) {
				response.sendRedirect("store.html");
			}else {
				response.sendRedirect("dlsb.html");
			}
		} catch (Exception e) {
			
		}
	}

}
