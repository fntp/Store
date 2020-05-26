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
        // Step 1: 配置邮件会话session
        System.out.println("Configuring mail session for: " + smtpHost);
        java.util.Properties props = new java.util.Properties();
        props.setProperty("mail.smtp.auth", "true");//指定是否需要SMTP验证
        props.setProperty("mail.smtp.host", smtpHost);//指定SMTP服务器
        props.put("mail.transport.protocol", "smtp");
        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);//是否在控制台显示debug信息

        // Step 2:  构建消息
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

        // Step 3:  开始发送HTML邮件
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(smtpHost, "mysinsy@163.com", "MSJDFRDOOZVHGCHF");
        transport.sendMessage(testMessage, testMessage.getAllRecipients());
        transport.close();

        System.out.println("Message sent!");
    }

//    public static void main(String[] args) {
    public Html_send(String emailaddress) {
        String path ="C:\\Users\\Administrator\\Desktop\\鑫软工作室2020版工作室网站\\images\\logo.png";
        String smtpHost = "smtp.163.com";
        String from = "mysinsy@163.com";
//        String to = "358566760@qq.com";
        String to = emailaddress;
        String subject = "鑫软科技"; 
        //subject javamail自动转码
        Verification demo =new Verification();
        Code=demo.getcode(demo.random_number(),demo.random_char());
        StringBuffer theMessage = new StringBuffer();
        theMessage.append("<html><head><style>body{background-color:white}#header{background-color:black;color:white;text-align:cent");
        theMessage.append("er;padding:5px;}#nav{color:white;line-height:30px;background-color:black;height:560px;width:150px;float:left;paddin");
        theMessage.append("g:5px;}#section {width:1000px;float:left;padding:10px;font-size:20px;}");
        theMessage.append("#footer {background-color:black;color:white;clear:both;text-align:center;padding:5px;}");
        theMessage.append("</style></head><body><div id=header><h1>鑫软科技</h1></div><div id=nav>感谢您使用鑫软产品<br>SINSY<br>鑫");
        theMessage.append("软工作室<br><hr size=3px noshade=true />");
        theMessage.append("<center>SINSY鑫软科技<br>竭诚为您服务！<br></center></div><div id=section><h2>");
        theMessage.append("鑫软注册验证码</h2><p class=yzm><h1>您的验证码是：<font color=\"red\"><center><h1>"+Code+"！</h1></center></font></h1></p><center><p>本");
        theMessage.append("验证码仅十分钟有效！请您尽快登陆您的注册页面，输如您上面的验证码进行快速验证码，请您务必保护好您的验证码");
        theMessage.append("不被别人知晓，这将作为您注册身份的唯一识别码，请妥善处理！</p><p>感谢您选择鑫软服务！鑫软工作室将竭诚为您");
        theMessage.append("服务！</p></center></div><div id=footer>Copyright &copy; All Servered By SINSY 鑫软科技</div></body></html>");
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