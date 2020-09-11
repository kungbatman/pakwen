package com.fileTest;

import com.fileTest.Entity.Taskplan;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.*;

public class TimerCallClient {
    public static void main(String[] args) {
        Taskplan taskplan = new Taskplan();
        taskplan.setMonth(5);
        taskplan.setDay(29);
        taskplan.setHour(15);
        taskplan.setMinute(47);
        taskplan.setSecond(10);
        taskplan.setId(2);

        //run();
//        run2();
//
        // taskTest();
        // gernerate(5,29,9,45,0);
          a(taskplan);
      // week();

    }


    static Integer month = 5;
    static Integer day = 29;
    static Integer hour = 9;
    static Integer minute = 45;
    static Integer second = 0;


    private static void run() {
        Timer timer = new Timer();
        NewTimerTask timerTask = new NewTimerTask();

        Calendar calendar = Calendar.getInstance();
        /*** 定制每日2:00执行方法 ***/
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 14);
        calendar.set(Calendar.SECOND, 0);

        Date date = calendar.getTime();


        //程序运行后立刻执行任务，每隔24h执行一次
        timer.schedule(timerTask, date, 24 * 60 * 60 * 1000);
    }


    private static void run2() {
        Timer timer = new Timer();
        NewTimerTask timerTask = new NewTimerTask();

        Calendar calendar = Calendar.getInstance();
        /*** 定制每日执行方法 ***/
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        Date date = calendar.getTime();

        System.out.println("当前定时器执行时间: " + date);

        //程序运行后立刻执行任务，每隔24h执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("随机生成的数字:");
            }
        }, date, 24 * 60 * 60 * 1000);
    }


    public static Map task(Integer a) {
        Map map = new HashMap();
        map.put(a + 1, a * 2);
        map.put(a + 2, a * 4);
        return map;
    }

    public static void taskTest() {


        Integer size = task(4).size();
        System.out.println("map长度: " + size);
        System.out.println("map：" + task(4)
        );
    }


    public static Map a(Taskplan taskplan) {

        Map map = new HashMap();
        //gernerate(1,5,29,9,45,0);
        map.put(taskplan.getId(), gernerate(taskplan));
        System.out.println("该定时任务ID为: " + taskplan.getId());
        System.out.println("map:-------" + map.entrySet());
        return map;
    }

    public static Integer gernerate(Taskplan taskplan) {

        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        /*** 定制每日执行方法 ***/
        calendar.set(Calendar.MONTH, taskplan.getMonth() - 1);
        calendar.set(Calendar.DAY_OF_MONTH, taskplan.getDay());
        calendar.set(Calendar.HOUR_OF_DAY, taskplan.getHour());
        calendar.set(Calendar.MINUTE, taskplan.getMinute());
        calendar.set(Calendar.SECOND, taskplan.getSecond());

        Date date = calendar.getTime();

        if (date.before(new Date())) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DAY_OF_MONTH, 1);
            date = c.getTime();
        }

        System.out.println("当前定时器执行时间: " + date);

        //程序运行后立刻执行任务，每隔24h执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("**********:" + "--------------");
            }
        }, date,  30000 * 60);


        int i = 0;
        while (true) {
            if (i > 10) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.println("定时器执行了？");
        return null;
    }

    public static void week() {
        Calendar calendar = Calendar.getInstance();
        int a = calendar.get(Calendar.WEDNESDAY);
        System.out.println("周几？ ****** " + a);

        Date date = calendar.getTime();
        System.out.println("周几？ ****** " + date);
        System.out.println("########"+getWeekOfDate(new Date()));
    }

    /**
     * 根据日期获得星期
     *
     * @param date
     * @return
     */

    public static String getWeekOfDate(Date date) {
        String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String[] weekDaysCode = {"0", "1", "2", "3", "4", "5", "6"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("intweek" + intWeek);
        String week = weekDaysCode[intWeek];
        System.out.println("intweek========" + week);
        return weekDaysCode[intWeek];
    }

}
