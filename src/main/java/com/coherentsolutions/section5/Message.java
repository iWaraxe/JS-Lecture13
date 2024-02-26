package com.coherentsolutions.section5;

// Using wait(), notify(), and notifyAll()
class Message {
    private String msg;

    public synchronized String take() {
        while (msg == null) {
            try {
                wait(); // Waits until a message is available
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String returnValue = msg;
        msg = null; // Reset message
        notifyAll(); // Notify waiting threads
        return returnValue;
    }

    public synchronized void put(String msg) {
        while (this.msg != null) {
            try {
                wait(); // Waits until the message is taken
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.msg = msg;
        notifyAll(); // Notify waiting threads
    }

    public static void main(String[] args) {
        Message message = new Message();

        // Producer thread
        Thread producerThread = new Thread(() -> {
            String[] messages = {"First", "Second", "Third"};
            for (String msg : messages) {
                message.put(msg);
                System.out.println("Put message: " + msg);
            }
            message.put("DONE");
        });

        // Consumer thread
        Thread consumerThread = new Thread(() -> {
            for (String msg = message.take(); !msg.equals("DONE"); msg = message.take()) {
                System.out.println("Took message: " + msg);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
