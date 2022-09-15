package concurrency.practice;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;

    private ReentrantLock lock;

    public BankAccount(double balance, String accountNumber, ReentrantLock lock) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = lock;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
        }
    }

    public synchronized void Rdeposit(double amount) {
        try {
            lock.lock();
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void Rwithdraw(double amount) {
        try {
            lock.lock();
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAN() {
        System.out.println(accountNumber);
    }
}
