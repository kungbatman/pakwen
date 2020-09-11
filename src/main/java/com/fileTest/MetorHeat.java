package com.fileTest;

import java.io.IOException;
import java.math.BigDecimal;

public class MetorHeat {

    public static void main(String[] args) throws IOException {
        String a = "201905";
        String b = "535.53";
        String year = a.substring(0,4);
        String month = a.substring(4,6);
        Integer year1 = Integer.valueOf(year);
        Double heatEngy = Double.valueOf(b);
        System.out.println(year);

        System.out.println(month);

        Integer M31 = 31;
        Integer M30 = 30;
        Integer M28 = 28;
        Integer M29 = 29;
        if (month.equals("01") ||month.equals("03") ||month.equals("05") ||month.equals("07") ||month.equals("08") ||month.equals("10") ||
                month.equals("12")){
            System.out.println("该月31天");
            double days[] = new double[M31];
            Double avgb = heatEngy / M31;
            BigDecimal bg = new BigDecimal(avgb);
             double avgb1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
             System.out.println("avgb1: " + avgb1);
            for(int i = 0; i < days.length; i ++ ){
                String date = String.valueOf(i+1);
                if (i+1 < 10){
                    date = "0" + date;
                }
                String day = a + date;
                days[i] = avgb1;
                if (i+1 == M31){
                    Double abgb2 = avgb1 + heatEngy - (M31 * avgb1);
                    BigDecimal bg1 = new BigDecimal(abgb2);
                    double avgb3 = bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    days[i] = avgb3;
                }
                System.out.println("日期为: " + day + ", 该日指标用量为: " + days[i]);
            }
        }
        if (month.equals("04") ||month.equals("06") ||month.equals("09") ||month.equals("11")){
            System.out.println("该月30天");
        }
        if (month.equals("02")){
            if(year1 %4 == 0 && year1 %100 != 0|| year1 %400 == 0){
                System.out.println("该年是闰年,该月29天");
            }else{
                System.out.println("该年是平年,该月28天");
            }
        }

    }

}
