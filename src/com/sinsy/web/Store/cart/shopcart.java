package com.sinsy.web.Store.cart;
import java.io.IOException;
import java.sql.SQLException;

import com.sinsy.web.usersql.JDBC;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class shopcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String chima=	request.getParameter("chima").replaceAll("\\s+","");
	String color  =	request.getParameter("color").replaceAll("\\s+","");
	String price = request.getParameter("price").replaceAll("\\s+","");
	String name = request.getParameter("name").replaceAll("\\s+","");
	String number =	request.getParameter("number");
	String img =	request.getParameter("img");
	String maijia =	request.getParameter("maijia");
//	String nickname = (String) request.getSession().getAttribute("nickname")+"666";
	String nickname="fntp";
	System.out.println("�û�"+nickname+"��ӽ����ﳵ���ǣ�"+name+"�����ǣ�"+chima+";color�ǣ�"+color+"�����ǣ�"+number+
			"�۸��ǣ�"+price+"ͼƬ��ַ��"+img+"�����ǣ�"+maijia);
	if(name!=null&&price!=null&&number!=null&&chima!=null&&color!=null) {
		JDBC yu = new JDBC();
		try {
			System.out.println(color);
			yu.insertIntoShop("scx","shop", nickname,name, price, number, chima, color,img,maijia);
			System.out.println("��ϲ�����Ѿ��ɹ����룡");
			HttpSession session = request.getSession();
			 session.setAttribute("name", name);
			 session.setAttribute("number", number);
			 session.setAttribute("chima",chima);
			 session.setAttribute("color",color);
			 session.setAttribute("price", price);
			 session.setAttribute("img", img);
			 session.setAttribute("maijia", maijia);
			 System.out.println("�����Ѿ�����session");
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
	
	response.getWriter().write("true");
	}

}
