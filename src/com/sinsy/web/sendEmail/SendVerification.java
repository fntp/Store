package com.sinsy.web.sendEmail;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;



/**
 * Servlet implementation class SendVerification
 */
public class SendVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendVerification() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		第一步获取前端发送到后端的值email地址
		String email =request.getParameter("email");
//		第二步 发送验证码
		Html_send yu = new Html_send(email);
//		第三步 保存验证码
		String code = yu.Code;
        HttpSession session=request.getSession();
		session.setAttribute("code",code);
//		request.
		System.out.println("成功向目标地址： {"+email+"}    发送了验证码邮件！");
		System.out.println("验证码是："+session.getAttribute("code"));
//		response.sendRedirect("/Store/register.html"); 
//		写到了使用ajax处理异步请求
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
