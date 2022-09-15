package concurrency;

import java.util.Random;

public class Messages {
    public static void main(String[] args) {

        MessageBroker messageBroker = new MessageBroker();
        (new Thread(new Producer(messageBroker))).start();
        (new Thread(new Consumer(messageBroker))).start();

    }
}

class MessageBroker {
    private String msg;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted at read");
            }
        }
        empty = true;
        notifyAll(); // Notify all threads that the resource is available
        return msg;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted at write");
            }
        }
        empty = false;
        this.msg = message;
        notifyAll();
    }
}

class Producer implements Runnable {
    private MessageBroker messageBroker;

    public Producer(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    public void run() {
        String[] messages = {
                "Olle dolle",
                "Doff!",
                "kinkelade",
                "koff!"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            messageBroker.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        messageBroker.write("Finished reading message queue.");
    }
}

class Consumer implements Runnable {
    private MessageBroker messageBroker;

    public Consumer(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    public void run() {
        Random random = new Random();

        for(String lastMsg = messageBroker.read(); !lastMsg.equals("Finished reading message queue.");
            lastMsg = messageBroker.read()) {
            System.out.println(lastMsg);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}
