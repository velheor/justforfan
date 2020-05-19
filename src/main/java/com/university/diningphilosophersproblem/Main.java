package com.university.diningphilosophersproblem;

class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((int) (Math.random() * 100));
    }

    @Override
    public void run() {
        try {
            doAction(": Thinking");
            synchronized (leftFork) {
                doAction(" : Picked up left fork");
                synchronized (rightFork) {
                    doAction(" : Picked up right fork and started eating");
                    doAction(" : Put down right fork");
                }
                doAction(" : Put down left fork and start thinking");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Philosopher[] philosopher = new Philosopher[5];
        Object[] fork = new Object[5];

        for (int i = 0; i < philosopher.length; i++) {
            fork[i] = new Object();
        }

        for (int i = 0; i < philosopher.length; i++) {
            Object leftFork = fork[i];
            Object rightFork = fork[(i + 1) % 5];

            //use this if condition to avoid dead lock
            if (i == philosopher.length - 1) {
                philosopher[i] = new Philosopher(leftFork, rightFork);
            } else {
                philosopher[i] = new Philosopher(rightFork, leftFork);
            }
            Thread t = new Thread(philosopher[i], " Philosopher " + (i + 1));
            t.start();
        }
    }
}