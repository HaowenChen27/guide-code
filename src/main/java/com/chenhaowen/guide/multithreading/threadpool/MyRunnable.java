package com.chenhaowen.guide.multithreading.threadpool;

import java.util.Date;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 上午11:05
 */
public class MyRunnable implements Runnable{

    private String command;


    public MyRunnable(String s) {
        this.command = s;
    }


    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.Time = " + new Date());

    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return this.command;
    }
}
