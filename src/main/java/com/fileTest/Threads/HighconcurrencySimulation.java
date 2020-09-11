package com.fileTest.Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kung
 * @date 2020-01-16 14:29
 * @Description
 */
public class HighconcurrencySimulation {
    public static class CurrentChatTest {

        //定义CyclicBarrier 的屏障，需要等多少个线程到了才发起请求
        CyclicBarrier cyclicBarrier = new CyclicBarrier(200);

        private void runThread() {
            //定义线程池
            ExecutorService executorService = Executors.newFixedThreadPool(400);
            //执行线程
            for (int i = 0; i < 400; i++) {
                executorService.submit(buildThread(i));
            }
        }

        private Thread buildThread(int i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread：" + Thread.currentThread().getName() + "准备...");
                        //cyclicBarrier一定要等到满200个线程到了才往后执行
                        cyclicBarrier.await();
                        System.out.println("Thread：" + Thread.currentThread().getName() + "开始执行");
                        //do something
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setName("name:" + i);
            return thread;
        }

    }

    public static class CurrentChatTest2 {

        //定义一个CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(1);

        public void countDownLatch() {
            ExecutorService executorService = Executors.newFixedThreadPool(200);
            for (int i = 0; i < 200; i++) {
                executorService.submit(createThread());
            }
            //计数器减一
            countDownLatch.countDown();
        }

        //创建线程
        private Thread createThread() {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread: " + Thread.currentThread().getName() + ", 准备...");
                        countDownLatch.await();
                        //do something
                        System.out.println("Thread: " + Thread.currentThread().getName() + ", 开始...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            return thread;
        }
    }

    public static void main(String[] args) {
//        CurrentChatTest currentChatTest = new CurrentChatTest();
//        currentChatTest.runThread();

        CurrentChatTest2 currentChatTests = new CurrentChatTest2();
        currentChatTests.countDownLatch();
    }
}
