package org.example.lesson_03.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private static final Object mon = new Object();

    public static void incrementAndPrint(AtomicInteger ai, int threadNumber)  {
        synchronized (mon) {
            int current = ai.incrementAndGet();
            System.out.println("Поток " + threadNumber + " увеличил значение на 1. Новое значение равно " + current);
        }
    }

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int iterations = 20;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                incrementAndPrint(ai, 1);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < iterations; i++) {
                incrementAndPrint(ai, 2);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                incrementAndPrint(ai, 3);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
