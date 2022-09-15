package concurrency;

public class CommonThreadBugsAndWorkarounds {

    public static void main(String[] args) throws InterruptedException {
        countDownRace();
//        countDownNoRace();


    }

    /**
     * No interference, since we have two separate Countdown objects passed to each resp. thread
     */
    private static void countDownNoRace() {
        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown1);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown2);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }

    private static void countDownRace() {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {
    // Introducing a global variable creates problems if both threads are accessing it the same time
    // This is b/c the variable is inside the same heap, this creates a RACE CONDITION
    private int i;

    public Countdown() {
    }

    /**
     * Synchronized tell the program, to let the whole method run to completion
     * before letting any other thread access it.
     */
    public synchronized void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_GREEN;
                break;
            default:
                color = ThreadColor.ANSI_RED;
        }

        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
        }
    }

    public void doCountdown2() {
        String color2;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color2 = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color2 = ThreadColor.ANSI_GREEN;
                break;
            default:
                color2 = ThreadColor.ANSI_RED;
        }

        // Synchronize on object level, since object instances are seen as different in memory
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color2 + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}


class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown threadCountdown) {
        this.threadCountdown = threadCountdown;
    }

    public void run() {
        //this.threadCountdown.doCountdown();
        this.threadCountdown.doCountdown2();
    }
}
