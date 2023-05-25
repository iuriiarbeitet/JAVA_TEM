package org.example;

/**
 * 7. Задача:
 * Создайте класс BankAccount, у которого есть баланс balance.
 * Создайте два потока, один из которых пытается снять средства со счета,
 * а другой пытается пополнить счет. Используйте синхронизированные блоки,
 * чтобы гарантировать корректное обновление баланса.
 */
public class Task7_BankAccount {
       private int balance;

        public Task7_BankAccount(int initialBalance) {
            this.balance = initialBalance;
        }

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            synchronized (this) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrawal successful. Amount: " + amount);
                } else {
                    System.out.println("Insufficient balance for withdrawal. Amount: " + amount);
                }
            }
        }
        public void deposit(int amount) {
            synchronized (this) {
                balance += amount;
                System.out.println("Deposit successful. Amount: " + amount);
            }
        }
        public static void main(String[] args) {
            Task7_BankAccount account = new Task7_BankAccount(5000);

            Thread withdrawalThread = new Thread(() -> {
                account.withdraw(500);
            });

            Thread depositThread = new Thread(() -> {
                account.deposit(1000);
            });

            withdrawalThread.start();
            depositThread.start();

            try {
                withdrawalThread.join();
                depositThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final balance: " + account.getBalance());
        }
}
