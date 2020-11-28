package com.chenhaowen.guide.multithreading.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 下午2:22
 */
public class CountDownLatchTest {


    static class MyRunnable implements Runnable {

        /**
         * 线程标记
         */
        private int num;

        private CountDownLatch countDownLatch;

        public MyRunnable(int num, CountDownLatch countDownLatch) {
            this.num = num;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                System.out.println("第" + num + "个线程开始执行任务...");
                Thread.sleep(2000);
                System.out.println("第" + num + "个线程结束执行任务...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();

        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyRunnable(i, countDownLatch));
            thread.start();
        }
        System.out.println("main thread wait.");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread end ...");
    }
}

