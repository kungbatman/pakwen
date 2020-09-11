package com.fileTest.Sechdule;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author kung
 * @date 2020-07-03 13:40
 * @Description
 */
public class MaskHH extends TimerTask{
    @Override
    public void run() {
        System.out.println("task execute ");
        System.out.println(Thread.activeCount() + " " + Thread.currentThread());
        System.out.println(new Date());
    }
}
