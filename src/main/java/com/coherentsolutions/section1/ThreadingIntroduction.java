package com.coherentsolutions.section1;

public class ThreadingIntroduction {
    public static void main(String[] args) {
        System.out.println("Hello from thread: " + Thread.currentThread().getName());
        // Create a thread using a Runnable
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello from thread: " + threadName);
        };

        task.run();

        // Create a thread object
        Thread thread = new Thread(task);
        thread.setName("Thread-1");

        thread.run();
        // Start the thread
        thread.start();

        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}

