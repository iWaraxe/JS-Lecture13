package com.coherentsolutions.section3;

public class ThreadLifecycleDemo implements Runnable {

    @Override
    public void run() {
        // The thread is currently in the Runnable state
        try {
            // This will move the thread to Timed Waiting state
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Handle the interruption
            e.printStackTrace();
        }
        System.out.println("State after sleeping: " + Thread.currentThread().getState());

        synchronized (this) {
            // Thread in Blocked state if another thread has the lock
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycleDemo obj = new ThreadLifecycleDemo();
        Thread thread = new Thread(obj);

        // The thread is currently in the NEW state.
        System.out.println("State after instantiation: " + thread.getState());

        thread.start();
        // The thread is now in the Runnable state.
        System.out.println("State after calling start(): " + thread.getState());

        Thread.sleep(200); // Main thread is sleeping
        System.out.println("State while Runnable: " + thread.getState());

        // Wait for Thread to die
        thread.join();
        // The thread is now in the Terminated state.
        System.out.println("State after completion: " + thread.getState());
    }
}

