package com.coherentsolutions.section4;
// Extending the Thread class
public class MyThread extends Thread {
    @Override
    public void run() {
        // Code that the thread executes
        System.out.println(Thread.currentThread().getName());
        System.out.println("This is a thread running by extending Thread class!");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start(); // Start the thread
    }
}

