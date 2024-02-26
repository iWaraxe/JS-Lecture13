package com.coherentsolutions.section3;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread running by implementing Runnable interface.");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start(); // Begin execution of the thread
    }
}
