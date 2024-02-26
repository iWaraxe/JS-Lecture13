package com.coherentsolutions.section4;
// Implementing the Runnable interface
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code that the thread will execute
        System.out.println("This is a thread running by implementing Runnable!");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // Start the thread
    }
}
