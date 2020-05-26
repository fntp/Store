package com.sinsy.web.sendEmail;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
public class Html_send {
	String Code=null;
    public static void sendMessage(String smtpHost,
                                   String from, String to,
                                   String subject, String messageText)
            throws MessagingException,java.io.UnsupportedEncodingException {
        // Step 1: �����ʼ��Ựsession
        System.out.println("Configuring mail session for: " + smtpHost);
        java.util.Properties props = new java.util.Properties();
        props.setProperty("mail.smtp.auth", "true");//ָ���Ƿ���ҪSMTP��֤
        props.setProperty("mail.smtp.host", smtpHost);//ָ��SMTP������
        props.put("mail.transport.protocol", "smtp");
        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);//�Ƿ��ڿ���̨��ʾdebug��Ϣ

        // Step 2:  ������Ϣ
        System.out.println("Constructing message -  from=" + from + "  to=" + to);
        InternetAddress fromAddress = new InternetAddress(from);
        InternetAddress toAddress = new InternetAddress(to);

        MimeMessage testMessage = new MimeMessage(mailSession);
        testMessage.setFrom(fromAddress);
        testMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);
        testMessage.setSentDate(new java.util.Date());
        testMessage.setSubject(MimeUtility.encodeText(subject,"gb2312","B"));

        testMessage.setContent(messageText, "text/html;charset=gb2312");
        System.out.println("Message constructed");

        // Step 3:  ��ʼ����HTML�ʼ�
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(smtpHost, "mysinsy@163.com", "MSJDFRDOOZVHGCHF");
        transport.sendMessage(testMessage, testMessage.getAllRecipients());
        transport.close();

        System.out.println("Message sent!");
    }

//    public static void main(String[] args) {
    public Html_send(String emailaddress) {
        String path ="C:\\Users\\Administrator\\Desktop\\��������2020�湤������վ\\images\\logo.png";
        String smtpHost = "smtp.163.com";
        String from = "mysinsy@163.com";
//        String to = "358566760@qq.com";
        String to = emailaddress;
        String subject = "����Ƽ�"; 
        //subject javamail�Զ�ת��
        Verification demo =new Verification();
        Code=demo.getcode(demo.random_number(),demo.random_char());
        StringBuffer theMessage = new StringBuffer();
        theMessage.append("<html><head><style>body{background-color:white}#header{background-color:black;color:white;text-align:cent");
        theMessage.append("er;padding:5px;}#nav{color:white;line-height:30px;background-color:black;height:560px;width:150px;float:left;paddin");
        theMessage.append("g:5px;}#section {width:1000px;float:left;padding:10px;font-size:20px;}");
        theMessage.append("#footer {background-color:black;color:white;clear:both;text-align:center;padding:5px;}");
        theMessage.append("</style></head><body><div id=header><h1>����Ƽ�</h1></div><div id=nav>��л��ʹ�������Ʒ<br>SINSY<br>��");
        theMessage.append("������<br><hr size=3px noshade=true />");
        theMessage.append("<center>SINSY����Ƽ�<br>�߳�Ϊ������<br></center></div><div id=section><h2>");
        theMessage.append("����ע����֤��</h2><p class=yzm><h1>������֤���ǣ�<font color=\"red\"><center><h1>"+Code+"��</h1></center></font></h1></p><center><p>��");
        theMessage.append("��֤���ʮ������Ч�����������½����ע��ҳ�棬�������������֤����п�����֤�룬������ر�����������֤��");
        theMessage.append("��������֪�����⽫��Ϊ��ע����ݵ�Ψһʶ���룬�����ƴ���</p><p>��л��ѡ����������������ҽ��߳�Ϊ��");
        theMessage.append("����</p></center></div><div id=footer>Copyright &copy; All Servered By SINSY ����Ƽ�</div></body></html>");
        try {
            Html_send.sendMessage(smtpHost, from, to, subject, theMessage.toString());
        }
        catch (MessagingException exc) {
            exc.printStackTrace();
        }
        catch (java.io.UnsupportedEncodingException exc) {
            exc.printStackTrace();
        }
		
    }
}