package com.coherentsolutions.section4;

// Example Walkthrough: Creating a Simple Thread
public class NumberPrinter extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        numberPrinter.start(); // Start the thread
    }
}
