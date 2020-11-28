package com.chenhaowen.guide.multithreading.aqs;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 下午2:50
 */
public class SemaphoreTest {

    // 限定线程数量
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        //模拟100个线程
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("===" + Thread.currentThread().getName() + "加入");
                        if (semaphore.availablePermits() == 0) {
                            System.out.println("线程已满");
                        }
                        // 尝试获取资源
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "成功获取资源");
                        Thread.sleep(new Random().nextInt(10000));
                        System.out.println(Thread.currentThread().getName() + "准备释放资源");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i + "");
            thread.start();

        }
    }
}
