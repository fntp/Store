package com.sinsy.web.Store.cart.list;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class getname extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = (String) request.getSession().getAttribute("nickname");
//		ֻΪ���ù��ﳵ����ʵ��ajax�첽ˢ���û���
		response.getWriter().write(nickname);
	}

}
