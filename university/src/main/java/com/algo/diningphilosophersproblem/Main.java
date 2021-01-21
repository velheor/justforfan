package com.algo.diningphilosophersproblem;

class Philosopher implements Runnable {
  private final Object leftFork;
  private final Object rightFork;
  private final int leftForkNum;
  private final int rightForkNum;
  private int foodLeft = 12;

  public Philosopher(Object leftFork, Object rightFork, int leftForkNum, int rightForkNum) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
    this.leftForkNum = leftForkNum;
    this.rightForkNum = rightForkNum;
  }

  public void doAction(String action) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " " + action);
    Thread.sleep(100);
  }

  @Override
  public void run() {
    try {
      while (foodLeft > 0) {
        doAction(": Thinking");
        synchronized (leftFork) {
          doAction("Food left : " + this.foodLeft + " : Picked up left fork" + leftForkNum);
          synchronized (rightFork) {
            doAction(
                "Food left: "
                    + this.foodLeft
                    + " : Picked up right fork "
                    + rightForkNum
                    + " and started eating");
            doAction("Food left : " + this.foodLeft + " : Put down right fork");
            this.foodLeft -= 1;
          }
          doAction("Food left : " + this.foodLeft + " : Put down left fork and start thinking");
        }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

public class Main {
  public static void main(String[] args) throws Exception {
    Philosopher[] philosopher = new Philosopher[6];
    Object[] fork = new Object[6];

    for (int i = 0; i < philosopher.length; i++) {
      fork[i] = new Object();
    }

    for (int i = 0; i < philosopher.length; i++) {
      Object leftFork = fork[i];
      Object rightFork = fork[(i + 1) % 6];

      if (i == philosopher.length - 1) {
        philosopher[i] = new Philosopher(leftFork, rightFork, i, (i + 1) % 6);
      } else {
        philosopher[i] = new Philosopher(rightFork, leftFork, (i + 1) % 6, i);
      }
      Thread t = new Thread(philosopher[i], " Philosopher " + (i + 1));
      t.start();
    }
  }
}
