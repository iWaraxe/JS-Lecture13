package com.coherentsolutions.section6;

public class VolatileExample {
    private static class SharedObject {
        private volatile boolean flag = true;

        public void performAction() {
            while (flag) {
                // Code for thread to execute while flag is true
                System.out.println("The flag is still true.");
            }
        }

        public void stopAction() {
            flag = false; // Other threads will see the updated value of flag immediately
            System.out.println("Flag updated to false.");
        }
    }

    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        // Thread to perform actions while flag is true
        Thread actionThread = new Thread(sharedObject::performAction);

        // Thread to stop actions by setting flag to false
        Thread stopActionThread = new Thread(() -> {
            try {
                Thread.sleep(500); // Sleep for a bit to allow actionThread to process
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sharedObject.stopAction();
        });

        actionThread.start();
        stopActionThread.start();
    }
}

