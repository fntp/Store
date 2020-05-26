package com.sinsy.web.userInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.apache.commons.beanutils.BeanUtils;
import com.sinsy.web.usersql.JDBC;
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		Person person = new Person();
		try {
			BeanUtils.populate(person, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(person.toString());
//		创建cookie，第一步设置编码
//		response.setContentType("text/html;charset=utf-8");
//		第二步，创建cookie从request中获取cookie
		Cookie cookies[] = request.getCookies();
//		第三步： 遍历cookie，获取相应的值
		for(int a=0;cookies!=null&&a<cookies.length;a++) {
//			获取每一个cookie的名字
			String name = cookies[a].getName();
//			获取每一个指定名字cookie的值
			String value = cookies[a].getValue();
			System.out.print("["+name+","+value+"]");
			System.out.print("  ");
		}
		System.out.println();
//		创建用于保存数据的cookie,供js调用
		String ClassName = "com.sinsy.web.userInfo.Person";
		Class c = null;
		try {
			c = Class.forName(ClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fs = c.getDeclaredFields();
//		创建一个数组用于保存注册页面表单提交的所有数据
//		首先使用linkedhashmap存储数据
		HttpSession seesion = request.getSession();	
		Map<String,Object> yu = new LinkedHashMap<String, Object>();
		for(Field field : fs) {
			System.out.println(field.getName()+","+ request.getParameter(field.getName()));
			yu.put(field.getName(),request.getParameter(field.getName()));
			seesion.setAttribute(field.getName(),request.getParameter(field.getName()) );
		}
//		request.getSession().setAttribute("my",user);
//		回显数据
//		PrintWriter out= response.getWriter();
//		out.print(yu.values());
//		System.out.println(yu.values());
//		System.out.println("nickname的属性值是"+yu.get("nickname").toString()+"数据类型是："+yu.get("nickname").toString().getClass().toString());
//		将注册信息注入sql中
			JDBC jdbc =new JDBC();
			try {
				jdbc.InsertInToTable("scx", "userinfo", yu.get("nickname").toString(), yu.get("phonenumber").toString(), 
						yu.get("email").toString(),yu.get("code").toString(),yu.get("sex").toString(),
						yu.get("birthday").toString(),yu.get("passwd").toString());
				System.out.println("鑫软心选提示：已有用户注册，数据已经插入数据库！");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/Store/cglogin");
			Date date=new Date();    
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			JOptionPane.showMessageDialog(null, "鑫软后台提示：用户 ID:"+request.getParameter("nickname")+
					"在"+formatter.format(date)+"已经完成注册！\n"
					+ "数据库已完成数据更新操作！请核实数据库信息！");
//			将请求转发
//			request.getRequestDispatcher("zhucechenggong.html").forward(request, response);
//			将请求重定向到指定html页面
	}

}
