package com.sinsy.web.ceshi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ceshi {
	public static void main(String[] args) {
		try {
			if(inthetable("scx", "userinfo", "nickname", "fntp", "123456")) {
				System.out.println("目标用户存在！");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static boolean inthetable(String database,String table,String key,String value,String pwd) throws ClassNotFoundException, SQLException {
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
public static  Connection GetConnection(String database) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
//    String url = "jdbc:mysql://localhost:3306/zhiyou_apartment?useUnicode=true&characterEncoding=utf-8&useSSL=false";
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
}
