package com.sinsy.web.sendEmail;


import java.util.Random;

public class Verification {
    //    第一步：目的：生成6位 随机校验码
//    @author fntp
//    算法实例
    public static  int random_int[]=new int[10];
    public static  char random_char[]=new char[52];
    //            校验码数字：
   public static int[] random_number(){
        for(int i=0;i<10;i++) {
            random_int[i]=i;
        }
        return random_int;
    }
    public  static char[] random_char(){
        for (int a=65;a<117;a++){
            if(a<=90)
                random_char[a-65]=(char)a;
            else if (a>96)
                random_char[a-71]=(char)a;
        }
        for (int b=46;b<52;b++) {
            random_char[b] = (char) (b+71);
        }
        return random_char;
    }
    //使用随机方法：
   public static String getcode(int number[],char zifu[]){
//        首先使用一个随机数：
        String result="";
        Random seed = new Random(10);
        Random number_use=new Random((int)(Math.random()*10));
        for (int b =0;b<6;b++){
            /**
             *  if(b<=4) {
             *                 result = result + number[number_use.nextInt(10)];
             *             }else if(b>4&&b<=6){
             *                 result = result +zifu[number_use.nextInt(52)];
             *             }
             *
             */
//            来点复杂的
            if(number[(int)(Math.random()*10)] < number[(int)(Math.random()*10)]){
                result = result +zifu[number_use.nextInt((int)(Math.random()*52))];
            }else{
                result = result + number[(int)(Math.random()*10)];
            }
        }
        return result;
    }
    public static void main(String[] args) {
//测试数字验证码是否好使？
//        System.out.println(Arrays.toString(random_number()));
// 测试字符验证码是否好使？
//        System.out.println(Arrays.toString(random_char()));
//        取出四位数字加两位字母
        System.out.println(getcode(random_number(),random_char()));
    }

}
