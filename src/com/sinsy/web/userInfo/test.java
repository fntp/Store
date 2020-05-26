package com.sinsy.web.userInfo;
import java.util.*;
import java.util.Map.Entry;
public class test {
		public static void main(String[] args) {
			Map<String,Object> yu = new LinkedHashMap<String, Object>();
			yu.put("a1", "fntp");
			yu.put("a2","123456");
			yu.put("a3","123456@qq.com");
			yu.put("a4",1234567811);
			 Iterator it = yu.entrySet().iterator();
			 System.out.println("依照加入顺序打印map");
			 int a=1;
			 while (it.hasNext()&&a<=4) {
//		            Map.Entry entity = (Map.Entry) it.next();
//		            System.out.println(entity);
				System.out.println(yu.get("a"+a).toString()+"对应输出的值的类型是："+yu.get("a"+a).getClass().toString());
				System.out.println();
				System.out.println(yu.get("a"+a)+"对应输出的值的类型是："+yu.get("a"+a).getClass().toString());
				a++;
		        }
			 System.out.println(yu.values().toString());
		}
		public static void save () {
			Map<String,Object> yu = new LinkedHashMap<String, Object>();
			yu.put("a1", "fntp");
			yu.put("a2","123456");
			yu.put("a3","123456@qq.com");
			yu.put("a4",123456789);
//			 Iterator it = map.entrySet().iterator();
			for(int a=0;a<yu.size();a++) {
				System.out.println(yu.get("a"+a));
			}
		}
}
