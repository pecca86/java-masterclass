package concurrency;

import static concurrency.ThreadColor.ANSI_CYAN;
import static concurrency.ThreadColor.ANSI_RED;

public class SleepingThreadsDemo {

    public static void main(String[] args) {

        Thread thread1 = new SubThread();
        thread1.start();

        Thread runnableThread1 = new Thread(new RunnableThread());
        runnableThread1.start();
        thread1.interrupt();


        // Joined threads
        Thread thread2 = new SubThread();
        thread2.start();
        Thread runnableThread2 = new Thread(new RunnableThread() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Running anonymous runnable thread: " + Thread.currentThread().getName());
                try {
                    //thread2.join(2000); // Wait for max 2sec before continuing
                    thread2.join();
                    System.out.println(ANSI_RED + "Joined thread terminated, I will start running again. " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "Interrupted: " + Thread.currentThread().getName());
                }
            }
        });

        runnableThread2.start();

    }
}
