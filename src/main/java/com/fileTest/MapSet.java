package com.fileTest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author kung
 * @date 2019-06-20 14:23
 * @Description
 */
public class MapSet {
    public static void main(String[] args) {
//            List<String> list1 = new ArrayList<String>();
//            List<String> list2 = new ArrayList<String>();
//            list1.add("ccc");
//            list1.add("ddd");
//            list1.add("aaa");
//            list1.add("bbb");
//            list2.add("bbb");
//            list2.add("ccc");
//
//            list1.retainAll(list2);
//            System.out.println("=-=-=-=****** 交集"  + list1);
//            list1.removeAll(list2);
//            System.out.println("=-=-=-=****** 差集"  + list1);

//            //map存放的键为list中的元素，值为元素出现的次数
//            HashMap<String, Integer> map = new HashMap<String, Integer>();
//            for(int i=0;i<list.size();i++){
//                String key = list.get(i);
//                Integer count = map.get(key);
//                //如果map中没有此键，则数量变成1，如果已存在，则数量自增1
//                if(count == null){
//                    count = 1;
//                }else{
//                    count ++;
//                }
//                map.put(key, count);
//            }
//
//            TreeSet<String> set = new TreeSet<String>();
//            for(String key : map.keySet()){
//                if(map.get(key)>1){
//                    set.add(key);
//                }
//            }
//            System.out.println(map);
//            System.out.println(set);

//            HashMap<String, Integer> map = new HashMap<String, Integer>();
//            map.put("a",1);
//            System.out.println(map.size());
//
//            System.out.println("--=============1==========" +  map.get("a").intValue());
//            map.put("a",3);
//            System.out.println(map.size());
//
//            System.out.println("--=============2=========" +  map.get("a").intValue());
//            map.put("b",3);
//            map.put("c",3);
//            map.put("c",4);
//            System.out.println(map.size());
//            map.get("c");
//            System.out.println("--=============3=========" +  map.get("c").intValue());
////            map.put("d",4);
//            if(map.get("d") == map.get("c")){
//                System.out.println("okkkkk");
//            }

//          int b = a();
//            System.out.println("b = " + b);

//        c("20200108");
        b(3);
    }

    public static int a() {
        int a = 0;
        b(a);
        System.out.println("a= " + a);
        Date time = new Date();
        String day = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String hour = new SimpleDateFormat("HH").format(new Date());
        String dayHour = day + hour;
        System.out.println("time: " + dayHour);
        String days = "2020010411";
        if (Integer.valueOf(dayHour) > Integer.valueOf(days)) {
            a = 3;
        }
        return a;
    }

    public static void b(int a) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("a",a);
            boolean t = true;
            if(map.get("c") == null || StringUtils.isEmpty(map.get("c").toString())){
                t = false;
            }
        System.out.println("值: " + t);
    }

    public static void c(String day) {
        String statisDay = day.replace("/","").replace("-","");
        System.out.println("statisDay: "  +statisDay);

    }
}
