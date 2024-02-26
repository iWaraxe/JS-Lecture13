package com.coherentsolutions.section3;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running by extending Thread class.");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); // Begin execution of the thread
    }
}
