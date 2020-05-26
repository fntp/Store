package com.sinsy.web.Store.cart.list;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;

public class splist {
	private String maijia=null;
	private String shangpinname=null;
	private String price=null;
	private String number=null;
	private String chima=null;
	private String color=null;
	private String imagepath=null;
	public String getMaijia() {
		return maijia;
	}
	public void setMaijia(String maijia) {
		this.maijia = maijia;
	}
	public String getShangpinname() {
		return shangpinname;
	}
	public void setShangpinname(String shangpinname) {
		this.shangpinname = shangpinname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getChima() {
		return chima;
	}
	public void setChima(String chima) {
		this.chima = chima;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
public static void main(String[] args) {
	splist user =new splist();
	user.setChima("6600");
	user.setColor("11");
	user.setImagepath("111");
	user.setMaijia("333");
	user.setNumber("ppp");
	user.setPrice("2222");
	user.setShangpinname("222");
	String userJson = JSON.toJSONString(user);
	try {
		System.out.println(userJson.toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
