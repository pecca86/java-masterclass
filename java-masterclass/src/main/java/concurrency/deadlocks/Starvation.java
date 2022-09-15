package concurrency.deadlocks;

import concurrency.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

public class Starvation {
    //private static Object lock = new Object();

    // Use a fair lock, true = fair
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new AWorker(ThreadColor.ANSI_BLUE), "Prio 10");
        Thread t2 = new Thread(new AWorker(ThreadColor.ANSI_GREEN), "Prio 8");
        Thread t3 = new Thread(new AWorker(ThreadColor.ANSI_RED), "Prio 6");
        Thread t4 = new Thread(new AWorker(ThreadColor.ANSI_CYAN), "Prio 4");
        Thread t5 = new Thread(new AWorker(ThreadColor.ANSI_PURPLE), "Prio 2");

        // Prio is only a SUGGESTION, the OS might not care about it
        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    private static class AWorker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public AWorker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: RunCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // Execute critical section
                } finally {
                    // Guarantees that the lock will be freed
                    lock.unlock();
                }
            }
        }
    }
}
