package com.fileTest.pangou;

import org.apache.http.impl.cookie.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author kung
 * @date 2019-07-03 19:11
 * @Description
 */
public class Dates {
    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        Date date = new Date();
//        System.out.println(sdf.format(date));
//        System.out.println(sdf.format(getLastDate(date)));
//        getSpecifiedDayBefore("20190824 ",15,-20);
//        getLastDate2(new Date());

//        dates();
//        bb();
//
//        getLastDate(new Date());


    }


    private static String getLastDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);
        String dayBefore=new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
        System.out.println("-******--- " + dayBefore);
        return dayBefore;
    }

    private static void getLastDate2(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,-14);
        String dayBefore=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
        System.out.println("-******--- " + dayBefore);
    }

    public static void getSpecifiedDayBefore(String specifiedDay,Integer hournow,Integer specifiedHour){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String now_time = new SimpleDateFormat("yyyyMMddHH").format(calendar.getTime());
        String year_now = specifiedDay.substring(0, 4);
        System.out.println("==== " + year_now + " *****&&&& ");
        String month_now = specifiedDay.substring(4, 6);
        System.out.println("==== " + month_now + " *****&&& ");
        String day_now = specifiedDay.substring(6,specifiedDay.length());
        System.out.println("==== " + day_now + " * ****&&&&& ");
        String now = year_now + "-" + month_now + "-" + day_now;
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        System.out.println("---- " + day);
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        c.set(Calendar.DATE,day-1);
        c.set(Calendar.HOUR_OF_DAY,hournow);
        int hournow2 = c.get(Calendar.HOUR_OF_DAY);
        System.out.println("==*****== " + hournow2);

        c.add(Calendar.HOUR_OF_DAY,specifiedHour);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        System.out.println("==== " + hour + "***** ");
//        String coll_day2 = DateUtils.formatDate(c.getTime(), "yyyyMMdd HH");
//        System.out.println( "***** " + coll_day2);
        String dayBefore=new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        String dayhourBefore=new SimpleDateFormat("yyyyMMddHH").format(c.getTime());
        System.out.println(dayBefore + "---- " + day + "==== " + hour + "***** "+ "^^^^^^*** " + dayhourBefore + " 本地时间 " + now_time );
        if(Integer.valueOf(now_time) < Integer.valueOf(dayhourBefore)){
            System.out.println("当前日期小于预测数据需要的日期，需要去预测表查询");
        }else {
            System.out.println("日期符合，天气表查询");
        }
        String dayhourBefore2 = dayhourBefore.substring(0,8);
        String dayhourBefore3 = dayhourBefore.substring(8,dayhourBefore.length());
        System.out.println("--==-=-= " + dayhourBefore2 + "==-=-=" + dayhourBefore3);
//        return dayBefore;
    }

    public static void dates(){
        Calendar cal = Calendar.getInstance();
        System.out.println("=============== " + cal.getTime() + cal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.HOUR_OF_DAY, 20);
        cal.add(Calendar.HOUR_OF_DAY,51);
        System.out.println("--------------- " + cal.getTime() + cal.get(Calendar.HOUR_OF_DAY));

        int a = 0;
        List list = new ArrayList();
        list.add("ha");
        list.add("ba");
        list.add("ka");
        list.add("ha");
        Map<String,Integer> map = new HashMap<>();
//        map.put("ha","1");
        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i).toString(),i);
            a += i*2;
        }
        System.out.println("=== " + map.size() + " --- " + map + " ===== " +  a);
    }

    public final static Map<String,String> map = new HashMap<>();
    public static void cc(){
        map.put("1","hah");
        map.put("2","hah");
        map.put("3","hah");
        map.put("4","hah");
        System.out.println("====map===== " + map + " --- " +  map.size());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);

        System.out.println("caa== " + calendar.getTime());
    }
    final static Calendar calendar = Calendar.getInstance();
    public static void bb(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        boolean b = list.contains(3);
        System.out.println(b);
        int a = -1;
        int a2 = -2;
        int b2 = a+(a2);
        System.out.println("b2=== " + b2);
        cc();
        map.clear();
        System.out.println("====map " + map + " --- " +  map.size());




        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 12);
        System.out.println("time is === " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 12);
        System.out.println("time2 is === " + calendar.getTime());

    }

}
