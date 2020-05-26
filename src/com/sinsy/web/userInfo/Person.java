package com.sinsy.web.userInfo;
import java.io.Serializable;

public class Person implements Serializable{
		private String nickname;
		private String phonenumber;
		private String email;
		private String code;
		private String sex;
		private String birthday;
		private String passwd;
//		无参数的构造方法
		public Person() {
			
		}
//		含有参数的构造方法（构造器）
//		public Person(String nickname, long phonenumber, String email, String sex, String birthday, String passwd) {
//			this.nickname = nickname;
//			this.phonenumber = phonenumber;
//			this.email = email;
//			this.sex = sex;
//			this.birthday = birthday;
//			this.passwd = passwd;
//		}

		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
//		测试是不是好使？
		public String toString() {
			return "Person [nickname=" + nickname + ", phonenumber=" + phonenumber + ", email=" + email + ", sex=" + sex
					+ ", birthday=" + birthday + ", passwd=" + passwd + "]";
		}
		
}
