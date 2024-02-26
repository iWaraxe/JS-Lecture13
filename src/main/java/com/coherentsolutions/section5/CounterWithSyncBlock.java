package com.coherentsolutions.section5;

// Synchronization with synchronized Block
public class CounterWithSyncBlock {
    private int count = 0;

    public void increment() {
        synchronized(this) {
            count++; // Only one thread can execute this at a time.
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CounterWithSyncBlock counter = new CounterWithSyncBlock();

        // Creating threads that increment the counter
        Thread t1 = new Thread(counter::increment);
        Thread t2 = new Thread(counter::increment);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + counter.getCount());
    }
}

