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
//		����cookie����һ�����ñ���
//		response.setContentType("text/html;charset=utf-8");
//		�ڶ���������cookie��request�л�ȡcookie
		Cookie cookies[] = request.getCookies();
//		�������� ����cookie����ȡ��Ӧ��ֵ
		for(int a=0;cookies!=null&&a<cookies.length;a++) {
//			��ȡÿһ��cookie������
			String name = cookies[a].getName();
//			��ȡÿһ��ָ������cookie��ֵ
			String value = cookies[a].getValue();
			System.out.print("["+name+","+value+"]");
			System.out.print("  ");
		}
		System.out.println();
//		�������ڱ������ݵ�cookie,��js����
		String ClassName = "com.sinsy.web.userInfo.Person";
		Class c = null;
		try {
			c = Class.forName(ClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fs = c.getDeclaredFields();
//		����һ���������ڱ���ע��ҳ����ύ����������
//		����ʹ��linkedhashmap�洢����
		HttpSession seesion = request.getSession();	
		Map<String,Object> yu = new LinkedHashMap<String, Object>();
		for(Field field : fs) {
			System.out.println(field.getName()+","+ request.getParameter(field.getName()));
			yu.put(field.getName(),request.getParameter(field.getName()));
			seesion.setAttribute(field.getName(),request.getParameter(field.getName()) );
		}
//		request.getSession().setAttribute("my",user);
//		��������
//		PrintWriter out= response.getWriter();
//		out.print(yu.values());
//		System.out.println(yu.values());
//		System.out.println("nickname������ֵ��"+yu.get("nickname").toString()+"���������ǣ�"+yu.get("nickname").toString().getClass().toString());
//		��ע����Ϣע��sql��
			JDBC jdbc =new JDBC();
			try {
				jdbc.InsertInToTable("scx", "userinfo", yu.get("nickname").toString(), yu.get("phonenumber").toString(), 
						yu.get("email").toString(),yu.get("code").toString(),yu.get("sex").toString(),
						yu.get("birthday").toString(),yu.get("passwd").toString());
				System.out.println("������ѡ��ʾ�������û�ע�ᣬ�����Ѿ��������ݿ⣡");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/Store/cglogin");
			Date date=new Date();    
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			JOptionPane.showMessageDialog(null, "�����̨��ʾ���û� ID:"+request.getParameter("nickname")+
					"��"+formatter.format(date)+"�Ѿ����ע�ᣡ\n"
					+ "���ݿ���������ݸ��²��������ʵ���ݿ���Ϣ��");
//			������ת��
//			request.getRequestDispatcher("zhucechenggong.html").forward(request, response);
//			�������ض���ָ��htmlҳ��
	}

}
