package concurrency;

/**
 * A Thread pool is a managed set of threads.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static concurrency.ProducerConsumerDemo.EOF;

public class ThreadPoolsDemo {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6); // Thread safe
        // If a thread has a lock and reaches a point that needs the same lock, it gets to use it again (has not to obtain it again)

        // Thread pool service
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadProducer producer = new ThreadProducer(buffer, ThreadColor.ANSI_RED);
        ThreadConsumer consumer = new ThreadConsumer(buffer, ThreadColor.ANSI_GREEN);
        ThreadConsumer consumer2 = new ThreadConsumer(buffer, ThreadColor.ANSI_BLUE);

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumer2);

        // Add new tasks
        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_PURPLE + "Callable future mother fucker!");
            return "This is the callable result";
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Oh noe!");
        } catch (InterruptedException e) {
            System.out.println("Shiiiiit, interrupted!");
        }

        // Executor service must be manually shut down, else the program won't stop running.
        // Will wait for threads to finish their work before shutting down.
        executorService.shutdown();
    }
}

class ThreadProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public ThreadProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding: " + num);
                buffer.put(num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting.");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e){
            System.out.println("Interrupted a producer put EOF");
        }
    }
}

class ThreadConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public ThreadConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {// Try to get the lock, if not available, do smth else
            // Although ArrayBlockingQueue is thread safe, our isEmpty() and peek() operations
            // Can produce faulty results if the ArrayBlockingQueue array is not synced
            synchronized (buffer) {
                try {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    if(buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting.");
                        break;
                    } else {
                        System.out.println(color + Thread.currentThread().getName() +" Removed: " + buffer.take());
                    }
                } catch (InterruptedException e){
                    System.out.println("Interrupted at consumer");
                }
            }
        }
    }
}


