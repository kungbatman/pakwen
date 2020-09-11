package com.fileTest;

import java.util.*;

public class Baiyangdian {
    public static void main(String args[]){
        /*char[] a=new char[100];
        String str;
        System.out.println("输入一个字符串：");
        Scanner in=new Scanner(System.in);
        str=in.nextLine();
        System.out.println(a);
        for(int i=0;i<str.length();i++){
            a[i]=str.charAt(i);
            System.out.print(a[i]+" ");
        }*/
//        int a[]={60,6,7,10,30,12,48,9,8};
//        //创建睡眠线程
//        SortThread t[]=new SortThread[a.length];
//        //初始化睡眠线程
//        for (int i = 0; i < t.length; i++) {
//            t[i]=new SortThread(a[i]);
//            t[i].start();
//        }

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list2.add("2");
        list2.add("7");
        list1.retainAll(list2);

        System.out.println("重复: " + list1);




    }
}
//sortThread是一个动态类，当做内部类的时候，加上static。否则放到作为外部类~~哈
class SortThread extends Thread{
    int ms;
    public SortThread(int ms){
        this.ms=ms;
    }
    @Override
    public void run() {
        super.run();
        try {
            sleep(ms*10+10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(ms);

    }

    public static Map b(){

        Map map = new HashMap();
        map.put("s",3);
      //  map.put("a",3);
        return map;
    }

    public static Map a(){

        Map map = new HashMap();

        map.put("a",3);
        return map;
    }




}
