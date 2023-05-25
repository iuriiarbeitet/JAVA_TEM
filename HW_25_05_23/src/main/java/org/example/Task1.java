package org.example;

/**
 * 1. Задача:
 * Создайте 5 потоков, которые выводят числа от 1 до 10.
 * Каждый поток должен использовать метод run() для вывода чисел.
 */
public class Task1 extends Thread{
        private static final Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
        public static void main(String[] args) {
            for (int i = 1; i <= 5; i++) {
                Thread thread = new Task1();
                thread.start();
            }
        }
}
