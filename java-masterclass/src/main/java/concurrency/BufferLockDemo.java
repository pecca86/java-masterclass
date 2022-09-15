package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static concurrency.ProducerConsumerDemo.EOF;

public class BufferLockDemo {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        // If a thread has a lock and reaches a point that needs the same lock, it gets to use it again (has not to obtain it again)
        ReentrantLock bufferLock = new ReentrantLock();
        OwnProducer producer = new OwnProducer(buffer, ThreadColor.ANSI_RED, bufferLock);
        OwnConsumer consumer = new OwnConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
        OwnConsumer consumer2 = new OwnConsumer(buffer, ThreadColor.ANSI_BLUE,  bufferLock);

        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer2).start();
    }
}

class OwnProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public OwnProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding: " + num);
                // Use the Reentrantlock
                bufferLock.lock();
                // To ensure we release the lock whe use a try-finally block
                try {
                    buffer.add(num);
                } finally {
                    // Release the lock, DEVELOPERS RESPONSIBILITY!
                    bufferLock.unlock();
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting.");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class OwnConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public OwnConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        long lockWaitCounter = 0;
        while (true) {
            // Try to get the lock, if not available, do smth else
            if (bufferLock.tryLock()) {
                try {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println("Waited " + lockWaitCounter + " times for the lock.");
                    if(buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting.");
                        break;
                    } else {
                        System.out.println(color + Thread.currentThread().getName() +" Removed: " + buffer.remove(0));
                    }
                } finally {
                  bufferLock.unlock();
                }
            } else {
                lockWaitCounter++;
                // Set sleep timer, to reduce busy waiting
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

