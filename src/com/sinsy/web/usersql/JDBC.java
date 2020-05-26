package com.sinsy.web.usersql;
/**
 * author fntp 2020/05/02
 */
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Arrays;
public class JDBC {
    //ʵ��ʹ��JDBC�������ݿ�MySQL
    private static String url = "jdbc:mysql://";
    private static String ip = "127.0.0.1:";
    private static int port = 3306;
    private static String target_database = "/scx";
    // MySQL����ʱ���û���
    private static String user = "root";
    // Java����MySQL����ʱ������
    private static String password = "root";
    public static String getMysql() {
        // URLָ��Ҫ���ʵ����ݿ���
        String URL = url + ip + port + target_database;
        //jdbc��������
        String driverName = "com.mysql.jdbc.Driver";
        try {
            // ������������
            Class.forName(driverName);
            // �������ݿ�
            Connection connection = DriverManager.getConnection(url, user, password);
            //ͨ�����ӻ�ȡstatement
            Statement statement = connection.createStatement();
            System.out.println("������ʾ���Ѿ��ɹ�������MySQL�������������ݿ�scx�ɹ���");
//            ����statement���������ȡ����
            String use_sql = "use scx;";
            ResultSet use_result = statement.executeQuery(use_sql);
            String show_sql = "show tables";
            ResultSet show_result = statement.executeQuery(show_sql);
            //            desc��ʽ��������ݱ���ֶνṹ��Ȼ���Ŀ���ֶν������ݲɼ������Ұ��ո�ʽ�������
//            String desc_table_sql_1 = "desc userinfo";
//            ResultSet desc_result_1 = statement.executeQuery(desc_table_sql_1);
//            String select_sql_getdates = "select * from userinfo";
//            ��ȡ����ִ�еĽ����
//            ��ѡ����������ݽ��и�ʽ�������Ŀ����Ϊ���������ݿ�ĸ���
            int tables_bunber = 0;
            while (show_result.next()) {
                tables_bunber += 1;
                System.out.println("��" + tables_bunber + "�����ݱ���:" + show_result.getString(1));
            }
//            while(desc_result_1.next()){
//                System.out.println("Ŀ�����ݱ���ֶ��ǣ�"+desc_result_1.getString("Field")+
//                        desc_result_1.getString("Type")+desc_result_1.getString("Null"));
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //    public static String gettable(){
////        ��һ������ȡĿ�����ݿ�����ݱ�
//        String sql_gettable= "show tables";
//        return sql_gettable;
//    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//       ���԰���
//        gettables();
//        ���԰���ʹ�õ��Ǿ�̬����
//        insertintable("�����","99love");
//        ��������Ϊ��̬�����Ϳ���ִ�У����ǷǾ�̬�������޷�ִ�е�
//        ��̬���������������������ʱ����е���
//        System.out.println(tablelength());
    }
//    ��Ŀ�����ݱ�������ݣ�1�����Է���
    public static void insertintable(String username,String userpasswd) throws SQLException, ClassNotFoundException {
        Statement statement = getConnection().createStatement();
        //        ���Ȼ�ȡ��ʼ���ı���������ֶεĳ���
        //          ������ڲ����þ�̬�Ŀ��Ե�
        int initlength = tablelength();
        //        Ȼ����в��������
        PreparedStatement pare_sql;
        pare_sql = getConnection().prepareStatement("insert into userinfo(username,userpasswd) "
                + "values(?,?)");
        pare_sql.setString(1, username);
        pare_sql.setString(2, userpasswd);
        //        String insert_sql = "insert into userinfo(username,userpasswd) values("+username+","+userpasswd+")";
        //        ResultSet resultSet = statement.executeQuery(insert_sql);
        //          �ж��Ƿ����ɹ���
        pare_sql.executeUpdate();
        int endlenth = tablelength();
        if (initlength < endlenth) {
            System.out.println("��ϲ�����Ѿ��ɹ��������ݣ�");
        } else {
            System.out.println("�ܱ�Ǹ������ʧ�ܣ�");
        }
    }
//    ������ע��sqlָ�����ݱ�2��ʹ�÷���
    public  void InsertInToTable(String database,String tablename,String nickname,String phonenumber,
    		String email,String code,String sex,String birthday,String passwd) throws SQLException, ClassNotFoundException {
        Statement statement = GetConnection(database).createStatement();
        //        ���Ȼ�ȡ��ʼ���ı���������ֶεĳ���
        //          ������ڲ����þ�̬�Ŀ��Ե�
        int initlength = tablelength();
        //        Ȼ����в��������
        PreparedStatement pare_sql;
        pare_sql = getConnection().prepareStatement("insert into "+tablename+"(nickname,phonenumber,email,code,sex,birthday,passwd) "
                + "values(?,?,?,?,?,?,?)");
        pare_sql.setString(1, nickname);
        pare_sql.setString(2, phonenumber);
        pare_sql.setString(3, email);
        pare_sql.setString(4, code);
        pare_sql.setString(5, sex);
        pare_sql.setString(6, birthday);
        pare_sql.setString(7, passwd);
        //        String insert_sql = "insert into userinfo(username,userpasswd) values("+username+","+userpasswd+")";
        //        ResultSet resultSet = statement.executeQuery(insert_sql);
        //          �ж��Ƿ����ɹ���
        pare_sql.executeUpdate();
        int endlenth = tablelength();
        if (initlength < endlenth) {
            System.out.println("��ϲ�����Ѿ��ɹ��������ݣ�");
        } else {
            System.out.println("�ܱ�Ǹ������ʧ�ܣ�");
        }
    }
//    �����ݽ���sql������Ʒ��Ϣ
    public void insertIntoShop(String database,String tablename,String user,String name,String price,
    		String number,String chima,String color,String img,String maijia) throws ClassNotFoundException, SQLException {
    	  Statement statement = GetConnection(database).createStatement();
    	  PreparedStatement pare_sql;
    	  pare_sql = getConnection().prepareStatement("insert into "+tablename+"(user,name,price,number,chima,color,img,maijia) "
                  + "values(?,?,?,?,?,?,?,?)");
    	  pare_sql.setString(1, user);
          pare_sql.setString(2, name);
          pare_sql.setString(3, price);
          pare_sql.setString(4, number);
          pare_sql.setString(5, chima);
          pare_sql.setString(6, color);
          pare_sql.setString(7,img);
          pare_sql.setString(8, maijia);
          pare_sql.executeUpdate();
    }
    
    
    
//    ��ȡtable
    public static void gettables() throws SQLException, ClassNotFoundException {
        Statement statement=getConnection().createStatement();
        String select_tables = "select * from userinfo";
        ResultSet resultSet = statement.executeQuery(select_tables);
            while(resultSet.next()){
            System.out.println(resultSet.getString("ID")+resultSet.getString("username")+"--"+resultSet.getString("userpasswd"));
        }
    }
//    �ж�Ŀ�����ݱ��Ƿ�Ϊ��
    public static boolean tableisnull() throws SQLException, ClassNotFoundException {
        Statement statement=getConnection().createStatement();
        String select_tables = "select * from userinfo";
        ResultSet resultSet = statement.executeQuery(select_tables);
        if(resultSet.next())
            return true;
        return false;
    }
//    ��Ŀ�������������������Ϊ���Ȱ���IDȡֵ��
    public static int tablelength() throws SQLException, ClassNotFoundException {
        Statement statement=getConnection().createStatement();
        String select_tables = "select * from userinfo";
        ResultSet resultSet = statement.executeQuery(select_tables);
       String length[]=new String[100];
       int a=0;
        while(resultSet.next()){
           length[a]=(resultSet.getString("ID"));
           a+=1;
        }
        int c=0;
       for(int b=0;b<length.length;b++){
           if (length[b]!=null)
               c++;
       }
        return c;
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/zhiyou_apartment?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/scx";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
             conn= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
//ʵսʹ�ã�
    public  Connection GetConnection(String database) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/zhiyou_apartment?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/"+database;
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
             conn= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
//TODO:��Ŀ�����ݽ�����֤����:
    public boolean inthetable(String database,String table,String key,String value,String pwd) throws ClassNotFoundException, SQLException {
    	 PreparedStatement pstmt = null;
     	  ResultSet rs =null;
        	  String sql= "select * from "+table+" where "+key+"="+"\""+value+"\""+" and passwd="+"\""+pwd+"\""+"; ";
     	  if(table!=null&&value!=null&&pwd!=null) {
     		  pstmt =  GetConnection(database).prepareStatement(sql);
     	  	  rs = pstmt.executeQuery();
     	  	while (rs.next()) {
     	  				return true;
     	  	}
     	  }
   		return false;
    }
    
}
