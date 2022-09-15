package concurrency;

import static concurrency.ThreadColor.*;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from main thread.");
        Thread subThread = new SubThread();
        subThread.start(); // Runs the thread

        System.out.println("Hi again, main here.");

        // Creating a one-time thread, which also starts it immediately
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous thread started.");
            }
        }.start();

        new Thread(() -> System.out.println(ANSI_RED + "Anonymous lambda thread started.")).start();

        // Thread that implements the runnable interface
        Thread myRunnableThread = new Thread(new RunnableThread());
        myRunnableThread.start();

        new Thread(new RunnableThread()) {
            public void run() {
                System.out.println("Runnable using anonymous class");
            }
        }.start();

        new Thread(new RunnableThread()).start();

    }
}
