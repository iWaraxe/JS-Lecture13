package com.coherentsolutions.section2;

class Task implements Runnable {
    private final String taskName;

    Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(taskName + " is running concurrently.");
    }
}

public class ConcurrencyExample {
    public static void main(String[] args) {
        Thread task1 = new Thread(new Task("Task 1"));
        Thread task2 = new Thread(new Task("Task 2"));

        task1.start();
        task2.start();
    }
}
