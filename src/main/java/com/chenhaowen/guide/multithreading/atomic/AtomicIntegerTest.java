package com.chenhaowen.guide.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenhaowen
 * @Description:
 * @date 2020/11/28 下午1:21
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        count.set(0);
        System.out.println(count.get());
        int i = count.getAndAdd(2);
        System.out.println(i);
        System.out.println(count.get());
        int i1 = count.getAndIncrement();
        System.out.println(i1);
        System.out.println(count.get());

        System.out.println("----------------------");
        boolean result = count.compareAndSet(3, 6);
        System.out.println(result);
        System.out.println(count.get());
    }



}
