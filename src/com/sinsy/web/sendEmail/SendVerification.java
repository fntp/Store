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
//		��һ����ȡǰ�˷��͵���˵�ֵemail��ַ
		String email =request.getParameter("email");
//		�ڶ��� ������֤��
		Html_send yu = new Html_send(email);
//		������ ������֤��
		String code = yu.Code;
        HttpSession session=request.getSession();
		session.setAttribute("code",code);
//		request.
		System.out.println("�ɹ���Ŀ���ַ�� {"+email+"}    ��������֤���ʼ���");
		System.out.println("��֤���ǣ�"+session.getAttribute("code"));
//		response.sendRedirect("/Store/register.html"); 
//		д����ʹ��ajax�����첽����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
