package com.fileTest.Sechdule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

public abstract class TimerTask {
    private final static Logger LOGGER = LoggerFactory.getLogger(TimerTask.class);

    /**
     * 每天23时执行
     */
    @Transactional(readOnly = false)
    @Scheduled(cron = "0 0 23 * * ?")
    public void setDb2txt() {
        LOGGER.info("生成txt文件定时任务启动");

    }


    public static void main(String[] args) throws IOException {
//// 将inputstream转换成字符流
//            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
////
//            BufferedReader reader = new BufferedReader(inputStreamReader);
//            File file = new File("D:\\A.txt");
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            String line;
//            while (!(line = reader.readLine()).equals("quit")) {
//                writer.write(line);
//                writer.newLine();
//            }
//            reader.close();
//            writer.close();
        hhhh();
    }

    public static void hhhh() {
        Timer timer = new Timer();
        String date1 = "2020-07-03 13:43:05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dt1;
        long ts1 = 0;
        try {
            dt1 = sdf.parse(date1);
            ts1 = dt1.getTime();
            System.out.println(date1 + ": " + sdf.format(ts1 +  1000));

            System.out.println("大小:" +dt1.compareTo(new Date()) + dt1 + " " + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer.schedule(new MaskHH(), new Date(ts1 + 1000));
    }
}




