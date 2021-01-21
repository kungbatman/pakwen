package com.fileTest.pangou;

import com.fileTest.Constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kung
 * @date 2021-01-14 9:39
 * @Description
 */
public class PressService implements Runnable {
    Logger logger = LoggerFactory.getLogger(PressService.class);
    public static ReentrantLock dealLock = new ReentrantLock(true);

    @Override
    public void run() {
        System.out.println("进线程" + Constant.fileQueue.size());

        while (!(Constant.fileQueue.size() <= 0)) {
            System.out.println("队列长度" + Constant.fileQueue.size());
            try {
                dealLock.lock();
                Iterator<String> it = Constant.fileQueue.iterator();
                while (it.hasNext()) {
                    String str = it.next();
                    deal(str);

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dealLock.unlock();
            }
        }
        System.out.println("空的");
    }

    synchronized void deal(String str) {
        System.out.println(("内容" + str));
        Constant.fileQueue.remove(str);
    }
}
