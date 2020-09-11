package com.fileTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class java2txt {

    //文件名保存格式：HB_BJXX_ 20131012013030.txt
    //时间格式: yyyyMMddHH24miss
    /**
     * 文件名由机构名称、文件类别、日期(精确到分)三部分组成，具体格式为：机构名称_文件类别_日期.txt
     *例如：HB_BJXX_ 20131012013030.txt
     *例如：采用数据量打循环处理时文件名采用自增流水号形式HB_BJXX_ 20131012013030_1.txt
     */



    // 创建JSONObject对象
     public static JSONObject StringCreateJson(JSONObject jsonObject){
        //JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","王尼玛");

        //粉丝是个数组,其实就是嵌套json
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","小王");
        jsonObject1.put("age",7);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","小尼玛");
        jsonObject2.put("age",10);

        //从此处可以看出其实list和json也是互相转换的
        List<JSONObject> jsonObjects = new ArrayList<>();
        jsonObjects.add(jsonObject1);
        jsonObjects.add(jsonObject2);
        jsonObject.put("fans",jsonObjects);

        System.out.println("jsonObject直接创建json:" + jsonObject);
        return jsonObject;
    }




    public static void main(String[] args) throws IOException {
        JSONObject jsonObject = new JSONObject();
        StringCreateJson(jsonObject);

        String str = "{'key':'value'}";



         String unit = "HB";
         String type = "BJXX ";
        //时间格式化格式
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        //获取当前时间并作为时间戳
        String timeStamp=simpleDateFormat.format(new Date());
         String fileName = unit + "_" + type + "_" + timeStamp + ".txt";
         String path = "F:/sotfile/";
         String fileName_ = unit + "_" + type + "_" + timeStamp + "_" + ".txt";

         int i;
        File file;//创建文件夹
        FileOutputStream stream = null;//new文件流
        try {
            FileOutputStream out = new FileOutputStream(path + fileName);
            OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
            BufferedWriter bufWrite = new BufferedWriter(outWriter);
            for (i = 0; i < jsonObject.size(); i++) {

                bufWrite.write(jsonObject + "\r\n");
            }
            bufWrite.close();
            outWriter.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取" + fileName + "出错！");
        }


    }
}
