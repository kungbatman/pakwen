package com.fileTest.Threads;

import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;

/**
 * @author kung
 * @date 2021-01-21 17:28
 * @Description
 */
public class ConnectTest {

    public static void main(String[] args) {
        int count = 100;
        final CountDownLatch cdl = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                    cdl.countDown();
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        connect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    public static void connect() throws Exception {
        final String urlStr = "https://blog.52itstyle.com/";
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.connect();
        System.out.println(urlConnection.getInputStream());
    }
}

