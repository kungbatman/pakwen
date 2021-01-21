package com.fileTest.pangou;

/**
 * @author kung
 * @date 2021-01-14 9:38
 * @Description
 */
public class TestThreadEnd {
    public static void main(String[] args) {
        subStr("3E2A1001E2002040602A1030102030501601710230125103");
    }

    public static void subStr(String msg) {
        if (!msg.startsWith("3E2A1001") || !msg.endsWith("03")) {
            System.out.println("注册包必须是以3E2A1001，03结尾，现在不是，注册失败");
        }

        String devId = msg.substring(4 * 2, 4 * 2 + 11 * 2);
        System.out.println(devId);
    }
}
