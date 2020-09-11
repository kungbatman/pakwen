package com.fileTest.BlockingQueuePekin;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author kung
 * @date 2019-09-27 14:02
 * @Description
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {

        int numProducers = 4;
        int numConsumers = 3;

        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<Object>(5);

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }

        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(myQueue)).start();
        }

        Thread.sleep(1000);

        System.exit(0);
    }
}
