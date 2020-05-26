package com.sinsy.web.usersql;
/**
 * author fntp 2020/05/02
 */
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Arrays;
public class JDBC {
    //实现使用JDBC连接数据库MySQL
    private static String url = "jdbc:mysql://";
    private static String ip = "127.0.0.1:";
    private static int port = 3306;
    private static String target_database = "/scx";
    // MySQL配置时的用户名
    private static String user = "root";
    // Java连接MySQL配置时的密码
    private static String password = "root";
    public static String getMysql() {
        // URL指向要访问的数据库名
        String URL = url + ip + port + target_database;
        //jdbc驱动名称
        String driverName = "com.mysql.jdbc.Driver";
        try {
            // 加载驱动程序
            Class.forName(driverName);
            // 连续数据库
            Connection connection = DriverManager.getConnection(url, user, password);
            //通过连接获取statement
            Statement statement = connection.createStatement();
            System.out.println("鑫软提示：已经成功加载至MySQL，并且连接数据库scx成功！");
//            利用statement输入命令获取数据
            String use_sql = "use scx;";
            ResultSet use_result = statement.executeQuery(use_sql);
            String show_sql = "show tables";
            ResultSet show_result = statement.executeQuery(show_sql);
            //            desc格式化输出数据表的字段结构，然后对目标字段进行数据采集，并且按照格式化输出！
//            String desc_table_sql_1 = "desc userinfo";
//            ResultSet desc_result_1 = statement.executeQuery(desc_table_sql_1);
//            String select_sql_getdates = "select * from userinfo";
//            获取命令执行的结果：
//            将选择出来的数据进行格式化输出，目的是为了区分数据库的个数
            int tables_bunber = 0;
            while (show_result.next()) {
                tables_bunber += 1;
                System.out.println("第" + tables_bunber + "个数据表是:" + show_result.getString(1));
            }
//            while(desc_result_1.next()){
//                System.out.println("目标数据表的字段是："+desc_result_1.getString("Field")+
//                        desc_result_1.getString("Type")+desc_result_1.getString("Null"));
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //    public static String gettable(){
////        第一步：获取目标数据库的数据表
//        String sql_gettable= "show tables";
//        return sql_gettable;
//    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//       测试案例
//        gettables();
//        测试案例使用的是静态方法
//        insertintable("孙程鑫","99love");
//        将方法改为静态方法就可以执行，但是非静态方法是无法执行的
//        静态方法不可以在申明对象的时候进行调用
//        System.out.println(tablelength());
    }
//    向目标数据表插入数据（1）测试方法
    public static void insertintable(String username,String userpasswd) throws SQLException, ClassNotFoundException {
        Statement statement = getConnection().createStatement();
        //        首先获取初始化的表的自增长字段的长度
        //          如果是内部调用静态的可以的
        int initlength = tablelength();
        //        然后进行插入操作，
        PreparedStatement pare_sql;
        pare_sql = getConnection().prepareStatement("insert into userinfo(username,userpasswd) "
                + "values(?,?)");
        pare_sql.setString(1, username);
        pare_sql.setString(2, userpasswd);
        //        String insert_sql = "insert into userinfo(username,userpasswd) values("+username+","+userpasswd+")";
        //        ResultSet resultSet = statement.executeQuery(insert_sql);
        //          判断是否插入成功！
        pare_sql.executeUpdate();
        int endlenth = tablelength();
        if (initlength < endlenth) {
            System.out.println("恭喜您！已经成功插入数据！");
        } else {
            System.out.println("很抱歉，插入失败！");
        }
    }
//    将数据注入sql指定数据表（2）使用方法
    public  void InsertInToTable(String database,String tablename,String nickname,String phonenumber,
    		String email,String code,String sex,String birthday,String passwd) throws SQLException, ClassNotFoundException {
        Statement statement = GetConnection(database).createStatement();
        //        首先获取初始化的表的自增长字段的长度
        //          如果是内部调用静态的可以的
        int initlength = tablelength();
        //        然后进行插入操作，
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
        //          判断是否插入成功！
        pare_sql.executeUpdate();
        int endlenth = tablelength();
        if (initlength < endlenth) {
            System.out.println("恭喜您！已经成功插入数据！");
        } else {
            System.out.println("很抱歉，插入失败！");
        }
    }
//    插数据进入sql保存商品信息
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
    
    
    
//    获取table
    public static void gettables() throws SQLException, ClassNotFoundException {
        Statement statement=getConnection().createStatement();
        String select_tables = "select * from userinfo";
        ResultSet resultSet = statement.executeQuery(select_tables);
            while(resultSet.next()){
            System.out.println(resultSet.getString("ID")+resultSet.getString("username")+"--"+resultSet.getString("userpasswd"));
        }
    }
//    判断目标数据表是否为空
    public static boolean tableisnull() throws SQLException, ClassNotFoundException {
        Statement statement=getConnection().createStatement();
        String select_tables = "select * from userinfo";
        ResultSet resultSet = statement.executeQuery(select_tables);
        if(resultSet.next())
            return true;
        return false;
    }
//    求目标数组的数据量（换算为长度按照ID取值）
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
//实战使用：
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
//TODO:讲目标数据进行验证操作:
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
