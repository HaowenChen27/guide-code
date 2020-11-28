package com.chenhaowen.guide.multithreading.threadpool;

import java.util.concurrent.*;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 下午3:56
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        scheduledThreadPoolTest();

    }

    private void allType() {
        //创建单个线程的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //创建使用固定线程数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        //创建一个会根据需要创建新线程的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        //创建拥有固定线程数量的定时任务的线程池
        Executors.newScheduledThreadPool(3);
    }

    /**
     * 单个定时线程池
     */
    private static void singleThreadScheduledExecutorTest() {
        //创建只有一个线程的定时线程任务的线程池
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("时间：" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            executorService.schedule(new Runnable() {
                public void run() {
                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },10, TimeUnit.SECONDS);
        }
    }

    /**
     * 多个定时线程池
     */
    private static void scheduledThreadPoolTest() {
        //创建拥有固定线程数量的定时线程任务的线程池
        ScheduledExecutorService es4 = Executors.newScheduledThreadPool(3);
        System.out.println("时间：" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            es4.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
                }
            },3,10, TimeUnit.SECONDS);
        }
    }
}
