package com.sinsy.web.sendEmail;


import java.util.Random;

public class Verification {
    //    ��һ����Ŀ�ģ�����6λ ���У����
//    @author fntp
//    �㷨ʵ��
    public static  int random_int[]=new int[10];
    public static  char random_char[]=new char[52];
    //            У�������֣�
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
    //ʹ�����������
   public static String getcode(int number[],char zifu[]){
//        ����ʹ��һ���������
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
//            ���㸴�ӵ�
            if(number[(int)(Math.random()*10)] < number[(int)(Math.random()*10)]){
                result = result +zifu[number_use.nextInt((int)(Math.random()*52))];
            }else{
                result = result + number[(int)(Math.random()*10)];
            }
        }
        return result;
    }
    public static void main(String[] args) {
//����������֤���Ƿ��ʹ��
//        System.out.println(Arrays.toString(random_number()));
// �����ַ���֤���Ƿ��ʹ��
//        System.out.println(Arrays.toString(random_char()));
//        ȡ����λ���ּ���λ��ĸ
        System.out.println(getcode(random_number(),random_char()));
    }

}
