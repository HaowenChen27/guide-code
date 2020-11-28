package com.chenhaowen.guide.multithreading.aqs;

import java.util.concurrent.CyclicBarrier;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 下午3:25
 */
public class CyclicBarrierTest {

    static class TaskThread extends Thread {
        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");
                Thread.sleep(2000);

                System.out.println(getName() + "到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "完成最后任务");
            }
        });

        for (int i = 0; i < 5; i++) {
            new TaskThread(barrier).start();
        }

    }
}
