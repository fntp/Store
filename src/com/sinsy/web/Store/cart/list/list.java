package com.sinsy.web.Store.cart.list;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
public class list extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String user=(String) request.getSession().getAttribute("nickname");
			String name =(String) request.getSession().getAttribute("name");
			String price = (String)  request.getSession().getAttribute("price");
			String number = (String)  request.getSession().getAttribute("number");
			String chima = (String)  request.getSession().getAttribute("chima");
			String color = (String)  request.getSession().getAttribute("color");
			String img = (String)  request.getSession().getAttribute("img");
			String maijia = (String)  request.getSession().getAttribute("maijia");
			String nickname = (String) request.getSession().getAttribute("nickname");
			System.out.println("访问购物车的是"+nickname);
			System.out.println(name+"1"+price+"2"+number+"3"+chima+"4"+color+"5"+img+"6"+maijia
					+"7"+nickname+"8");
//			if(user!=null&&name!=null&&price!=null&&number!=null&&chima!=null
//					&&color!=null&&img!=null&&maijia!=null) {
//				给前端返回json对象
				String userJson = JSON.toJSONString(UserDAO(name,price,number,chima,color,img,maijia));
				response.setContentType("application/json; charset=utf-8");
				response.setCharacterEncoding("UTF-8");
				OutputStream out = response.getOutputStream();
				out.write(userJson.getBytes("UTF-8"));
				out.flush();
//			}else {
//				response.getWriter().write(nickname);
				
//			}
				
	}
	public splist UserDAO(String name,String price,String number,String chima,String color,String img,String maijia) {
		splist user = new splist();
		user.setShangpinname(name);
		user.setPrice(price);
		user.setNumber(number);
		user.setChima(chima);
		user.setColor(color);
		user.setImagepath(img);
		user.setMaijia(maijia);
		return user;
	}
}
