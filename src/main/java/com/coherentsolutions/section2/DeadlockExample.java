package com.coherentsolutions.section2;

class Friend {
    private final String name;

    Friend(String name) {
        this.name = name;
    }

    synchronized void bow(Friend bower) {
        System.out.format("%s: %s has bowed to me!%n", this.name, bower.name);
        bower.bowBack(this);
    }

    synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s has bowed back to me!%n", this.name, bower.name);
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        final Friend alice = new Friend("Alice");
        final Friend bob = new Friend("Bob");

        new Thread(() -> alice.bow(bob)).start();
        new Thread(() -> bob.bow(alice)).start();
    }
}
