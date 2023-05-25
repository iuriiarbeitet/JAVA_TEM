package org.example;

/**
 * 2. Задача:
 * Создайте 3 потока, которые вычисляют и выводят квадраты чисел от 1 до 10.
 * Каждый поток должен использовать метод run() для вычисления и вывода квадратов.
 */
public class Task2 extends Thread{
        private static final Object lock = new Object();
        private static int number = 1;

        @Override
        public void run() {
            synchronized (lock) {
                 for (int i = 0; i < 10; i++) {
                    int square = number * number;
                    System.out.println(Thread.currentThread().getName() + ": " + square);
                    number++;
                }
            }
        }
        public static void main(String[] args) {
            Thread thread1 = new Task2();
            Thread thread2 = new Task2();
            Thread thread3 = new Task2();
            thread1.setName("Thread - 1");
            thread2.setName("Thread - 2");
            thread3.setName("Thread - 3");
            thread1.start();
            thread2.start();
            thread3.start();

        }
}
