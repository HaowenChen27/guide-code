package com.chenhaowen.guide.multithreading.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 上午11:10
 */
public class ThreadPoolExecutorDemo {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 10;

    /**
     * 任务队列容量
     */
    private static final int QUEUE_CAPACITY = 100;

    /**
     * 等待时间
     */
    private static final Long KEEP_ALIVE_TIME = 1L;


    public static void main(String[] args) {
        // alibaba 推荐创建线程池的方式
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }

        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
            //等待线程池停止
        }
        System.out.println("Finished all Threads");
    }
}
