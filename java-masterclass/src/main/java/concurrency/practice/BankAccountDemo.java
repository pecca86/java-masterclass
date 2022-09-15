package concurrency.practice;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccountDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        BankAccount pekka = new BankAccount(1000, "FI10", lock);


        // Deposit 300, then withdraw 50
        new Thread(() -> {
            pekka.Rdeposit(300);
            pekka.Rwithdraw(50);
        }).start();

        // Deposit 203.75, withdraw 100
        new Thread(() -> {
            pekka.Rdeposit(203.75);
            pekka.Rwithdraw(50);
        }).start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Running...");
            }
        };

        thread.start();

        System.out.println(pekka.getBalance());
    }
}
