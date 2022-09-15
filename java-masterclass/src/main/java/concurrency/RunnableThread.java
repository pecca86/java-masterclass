package concurrency;

import static concurrency.ThreadColor.ANSI_CYAN;
import static concurrency.ThreadColor.ANSI_RED;

public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Imma runnable thread: " + Thread.currentThread().getName());
    }
}
