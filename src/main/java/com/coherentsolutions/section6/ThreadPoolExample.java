package com.coherentsolutions.section6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a thread pool with 3 threads

        // Assign tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running on: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Initiates an orderly shutdown after all tasks finish
    }
}
