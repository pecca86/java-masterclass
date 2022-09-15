package concurrency;

import static concurrency.ThreadColor.ANSI_BLUE;
import static concurrency.ThreadColor.ANSI_CYAN;

public class SubThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from SubThread: " + currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another Thread woke me up. " + currentThread().getName());
            return;
        }

        System.out.println(ANSI_CYAN + "Three sec passed, awake again. " + currentThread().getName());
    }
}
