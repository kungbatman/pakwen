package com.fileTest.pangou;

import java.io.Serializable;

/**
 * @author kung
 * @date 2019-09-25 13:48
 * @Description
 */
public class HeatForecastDaysHttpBean implements Serializable{

    /**
     * time：输入时间（格式为：yyyy-MM-dd）
     * timeTwo:输入地点（蓟州，天津市区，宝坻，武清，宁河，静海，北辰，西青，津南，东丽，滨海新区，渤海）
     * type:输入类型（“06”，”11”，”17”）
     */

    private String time;
    private String timeTwo;
    private String type;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeTwo() {
        return timeTwo;
    }

    public void setTimeTwo(String timeTwo) {
        this.timeTwo = timeTwo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
