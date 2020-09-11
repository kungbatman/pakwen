package com.fileTest.pangou;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author kung
 * @date 2019-08-05 9:12
 * @Description
 */
public class LambdaDemo {
    public static void main(String[] args){
//        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
//        stringIndex("(54.35*(24-Tout(-20))+51.49*(24-(Tout(-1)-Vout(-1)/2))*(1)-0.63*Iout(-1)" +
//                "+(23*(24-Tout(-1))))/709.32+24+((54.35*(24-Tout(-20))+51.49*(24-(Tout(-1)-Vout(-1)/2))" +
//                "*(1)-0.63*Iout(-1)+(23*(24-Tout(-1))))^(1/2.2248))/2.1");
//        stringIndex("(54.35*(24-Tout(-20))+51.49*(24-(Tout(-1)-Vout(-1)/2))*(1)-0.63*Iout(-1)"  +
//                            "+(23*(24-Tout(-1))))/709.32+24+((54.35*(24-Tout(-20))+51.49*(24-(Tout(-1)-Vout(-1)/2))" +
//                              "*(1)-0.63*Iout(-1)+(23*(24-Tout(-1))))^(1/2.2248))/2.1");

//        a();
        b();
    }

public static void lambda1(){
    // Java 8之前：
    List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    for (String feature : features) {
        System.out.println(feature);
    }

//// Java 8之后：
//    List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//    features.forEach(n -> System.out.println(n));
//
//// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
//// 看起来像C++的作用域解析运算符
//    features.forEach(System.out::println);
}

public static List<String> list = new ArrayList<>();
    public static void stringIndex(String str){
            if(str.indexOf("Tout")!= -1){
                String newStr = str.substring(str.indexOf("Tout"),str.indexOf("Tout")+8);
                list.add(newStr+")");
                stringIndex(str.replace(newStr,""));
            }else if(str.indexOf("Vout")!= -1){
                String newStr2 = str.substring(str.indexOf("Vout"),str.indexOf("Vout")+8);
                stringIndex(str.replace(newStr2,""));
                list.add(newStr2+")");
        }else if(str.indexOf("Iout")!= -1){
                String newStr3 = str.substring(str.indexOf("Iout"),str.indexOf("Iout")+8);
                stringIndex(str.replace(newStr3,""));
                list.add(newStr3+")");
        }
//        System.out.println("list==== " + list);
        List<String> listNew=new ArrayList<>(new HashSet(list));
//        System.out.println("listNew =" + listNew );
    }

    public static void a(){
        String s = "(54.35*(24-23.6)+51.49*(24-(23.9-3.5/2))*(1)-0.63*0.231+(0))/709.32+24+((54.35*(24-23.6)+51.49*(24-(23.9-3.5/2))*(1)-0.63*0.231+(0))^(1/2.2248))/2.1";

        BigDecimal d = BigDecimal.valueOf( Long.parseLong(s));
        System.out.println("+++++" + d);
    }

    public static void b(){
        Map<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","2");
        map.put("3","2");
        System.out.println("Map长度为 " + map.size());
    }
}
