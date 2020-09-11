package com.fileTest.pangou;

import com.fileTest.Constant.Constant;
import com.sun.javafx.binding.IntegerConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kung
 * @date 2019-11-02 13:48
 * @Description
 */
public class ModelHeatExchStation {
    public static void main(String[] args){
       String hahah = datesReturn();
        System.out.println("时间区间为: " + hahah);
    }

    public static String datesReturn(){
        String start = "";
        String end = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

        String dateNowYear = sdf.format(date);
        String dateNowday = sdf2.format(date);

        String returnDate = "";

        try {
            start = Integer.parseInt(dateNowYear) + Constant.start_heat.replace("-", "");
            end = Integer.parseInt(dateNowYear) + Constant.end_heat.replace("-", "");
            //起始日期大于终止日期 跨年
            if(Integer.valueOf(Constant.start_heat.replace("-","")) >
                    Integer.valueOf(Constant.end_heat.replace("-",""))){
                if(Integer.valueOf(dateNowday) >= Integer.valueOf(start) || Integer.valueOf(dateNowday) <= Integer.valueOf(end)){
                    System.out.println("时间跨年,在供暖期");
                    if(Integer.valueOf(dateNowday) >= Integer.valueOf(start)){
                        returnDate = start + "-" + dateNowday;
                    }else if(Integer.valueOf(dateNowday) <= Integer.valueOf(end)){
                        returnDate = Integer.parseInt(dateNowYear) - 1 + Constant.start_heat.replace("-", "") + "-" + dateNowday;
                    }
                }else {
                    System.out.println("时间跨年,不在供暖期");
                    returnDate = Integer.parseInt(dateNowYear) - 1 + Constant.start_heat.replace("-", "") + "-" + end;
                }
            }else if(Integer.valueOf(Constant.start_heat.replace("-","")) <
                    Integer.valueOf(Constant.end_heat.replace("-",""))){
                //起始日期小于终止日期 不跨年
                if(Integer.valueOf(dateNowday) >= Integer.valueOf(start) && Integer.valueOf(dateNowday) <= Integer.valueOf(end)){
                    System.out.println("时间不跨年,在供暖期");
                    returnDate = start + "-" + dateNowday;
                }else {
                    System.out.println("时间不跨年,不在供暖期");
                    returnDate = start + "-" + end;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }
}
