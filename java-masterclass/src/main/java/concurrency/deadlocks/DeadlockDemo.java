package concurrency.deadlocks;

/**
 * Deadlock occurs when 2 or more threads a interdependent on locks that each other hold, and one thread cannot
 * release its lock before acquiring the other.
 *
 *  SOLUTION 1:
 *  Make threads obtain the locks in the same order.
 */
public class DeadlockDemo {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    /**
     * Thread 1
     */
    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " has lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock2");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " has lock1 and lock2");
                }
                System.out.println(Thread.currentThread().getName() + " released lock2");
            }
            System.out.println(Thread.currentThread().getName() + " released lock1. Exiting...");
        }
    }

    /**
     * Thread 2
     */
    private static class Thread2 extends Thread {
        private String name = Thread.currentThread().getName();
        public void run() {
            synchronized (lock2) {
                System.out.println(name + " has lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println(name + " waiting for lock 1");
                synchronized (lock1) {
                    System.out.println(name + " has lock 2 and lock1");
                }
                System.out.println(name + " released lock1");
            }
            System.out.println(name + " released lock2. Exiting...");
        }
    }
}

