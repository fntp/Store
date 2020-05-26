package com.sinsy.web.Store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.sinsy.web.userInfo.Person;
import com.sinsy.web.userInfo.User;

/**
 * Servlet implementation class UserDao
 */
public class UserDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession yu = request.getSession();
//		for (int i = 0; i < cookies.length; i++) {
//			System.out.println("cookie的名字是："+cookies[i].getName());
//			System.out.println("cookie的值是"+cookies[i].getValue());
//		}
		Enumeration<String> userinfo=yu.getAttributeNames();
		while (userinfo.hasMoreElements()) {
			String string = (String) userinfo.nextElement();
			System.out.println("数据"+string+"对应的值是："+yu.getAttribute(string));
		}
		String nickname = (String) yu.getAttribute("nickname");
		System.out.println("获取到的用户的nickname是："+nickname);
		response.setContentType("text/html;charset=utf-8");
//		request.setAttribute(nickname, yu.getAttribute("nickname"));
		response.sendRedirect("store.html");
	}

}
