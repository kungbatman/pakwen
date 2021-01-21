package com.fileTest.pangou;

import com.alibaba.druid.util.jdbc.StatementBase;
import com.fileTest.Constant.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kung
 * @date 2021-01-14 9:44
 * @Description
 */
public class TestPressService {
    public static ExecutorService excutorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Constant.fileQueue.add("A");
        Constant.fileQueue.add("B");
        Constant.fileQueue.add("C");
        Constant.fileQueue.add("D");
        Constant.fileQueue.add("E");
        Constant.fileQueue.add("F");
        Constant.fileQueue.add("G");
        System.out.println(Constant.fileQueue.size());
        if (!PressService.dealLock.isLocked()) {
            excutorService.execute(new PressService());
        }
        excutorService.shutdown();
    }
}
