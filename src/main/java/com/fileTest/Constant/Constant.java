package com.fileTest.Constant;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author kung
 * @date 2019-10-21 14:24
 * @Description
 */
public class Constant {
    /**超时*/
    public static int CODE_TIMEOUT = 408;

    /**
     * 模拟换热站
     */
    public static String start_heat = "11-01";
    public static String end_heat = "03-31";
    public static ConcurrentLinkedQueue<String> fileQueue = new ConcurrentLinkedQueue<>();
}
