package com.fileTest;

/**
 * @author kung
 * @date 2019-06-18 13:46
 * @Description
 */
public class Panggou {
    public static void main(String[] agrs){
       A a = new A();
       for(int i = 0; i < 10; i ++ ){
           a.arr[i] = i;
           int j = i+1;
           a.setStr("这是第 " + j + " 个");
           System.out.println("aaaaaaaaaaaa     " + a.arr[i] + a.getStr());
       }
    }
}

class A{
   public int[] arr = new int[10];
   private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
