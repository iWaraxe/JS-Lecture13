package com.coherentsolutions.section7;

public class Restaurant {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        // Create and start chef threads
        Thread chef1 = new Thread(new Chef(kitchen), "Chef John");
        Thread chef2 = new Thread(new Chef(kitchen), "Chef Emma");
        // ... more chefs if needed

        chef1.start();
        chef2.start();
        // ... start more chef threads
    }
}

class Chef implements Runnable {
    private final Kitchen kitchen;

    // Constructor to initialize shared resources
    public Chef(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        // Implement the cooking process here
        System.out.println(Thread.currentThread().getName() + " is starting to cook.");
        kitchen.useOven();
        System.out.println(Thread.currentThread().getName() + " has finished cooking.");
    }
}

class Kitchen {
    private final Object ovenLock = new Object();

    public void useOven() {
        synchronized(ovenLock) {
            // Code for using the oven
            System.out.println(Thread.currentThread().getName() + " is using the oven.");
            try {
                Thread.sleep(1000); // Simulating the oven use time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done using the oven.");
        }
    }
}
