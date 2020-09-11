package com.fileTest.pangou;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author kung
 * @date 2019-07-04 14:04
 * @Description
 */
public class Hex {
//    00104A3B00

    public static void main(String[] args){
        /** Hex to Bi*/
//        String hexAddr = "00104A3B00";
//        char[] str = hexAddr.toCharArray();
//        String a = String.valueOf(str[4]);
//        String b = String.valueOf(str[5]);
//        String c = String.valueOf(str[6]);
//        String d = String.valueOf(str[7]);
//        String addr = a+b+c+d;
//        String newStr = new BigInteger(addr, 16).toString(10);
//        System.out.println("地址为:  " + newStr);
//        devEnv();

//        stringBuilder();

        List<String> list = new ArrayList<>();
        list.add("2019-07-23");
        list.add("2019-07-24");
        list.add("2019-07-25");
        list.add("2019-07-31");
        findDates("2019-07-24","2019-07-31");
    }

    public static void devEnv(){
        Map<String, Map<String, String>> map = new HashMap<>();
        map.put("genenv",System.getenv());
        System.out.println("本机用户名为: " + map.get("genenv").get("USERDOMAIN"));
        System.out.println("本机: " + map.get("genenv"));
    }

    public static void stringBuilder(){
        String a = "is a good man";
        StringBuilder stringBuilder = new StringBuilder("kung");
        String cmd = stringBuilder.append("-").append("pakwen").append(" ").append(a).toString();
        System.out.println("He said: \"" + cmd + "\"");
    }


    //JAVA获取某段时间内的所有日期 月份
    public static List<String> findDatesYear(String dStart, String dEnd) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM");
        //先将日期换成月份制
        List<String> dateList=null;
        try {
            Date date=sdf2.parse(sdf2.format(sdf.parse(dStart)));//2018-01 date
            Date datelast=sdf2.parse(sdf2.format(sdf.parse(dEnd)));
            String dateSpring=sdf2.format(sdf.parse(dStart)); //2018-01
            Calendar car = Calendar.getInstance();
            car.setTime(date);
            dateList = new ArrayList<String>();
            //别忘了，把起始日期加上
            dateList.add(dateSpring);
            //此日期是否在指定日期之后
            while (datelast.after(car.getTime())) {
                //根据日历的规则，为给定的日历字段添加或减去指定的时间量
                car.add(Calendar.MONTH ,1);
                dateList.add(sdf2.format(car.getTime()));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("dateList"+ dateList);
        return dateList;

    }

    //JAVA获取某段时间内的所有日期
    public static List<String> findDates(String dStart, String dEnd) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateList=null;
        try {
            Calendar cStart = Calendar.getInstance();
            cStart.setTime(sdf.parse(dStart));
            dateList = new ArrayList<String>();
            //别忘了，把起始日期加上
            dateList.add(dStart);
            // 此日期是否在指定日期之后
            while (sdf.parse(dEnd).after(cStart.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                cStart.add(Calendar.DAY_OF_MONTH, 1);
                dateList.add(sdf.format(cStart.getTime()));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("dateList"+ dateList);
        return dateList;
    }

}
