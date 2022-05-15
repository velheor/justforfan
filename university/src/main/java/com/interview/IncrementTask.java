package com.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IncrementTask implements Runnable {
    //Integer i = 0;
    @Override
    public void run() {
        Integer i = 0;
        System.out.println(i++);
    }

    public static void main(String... args) {
        Runnable task = new IncrementTask();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(task);
        service.submit(task);
        service.submit(task);
        service.submit(task);
        service.submit(task);
    }
}