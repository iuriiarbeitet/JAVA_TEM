package org.example;

/**
 * 5. Задача:
 * Создайте 3 потока, каждый из которых выводит свое имя 5 раз.
 *  Каждый поток должен использовать метод run() для вывода имени.
 */
public class Task5 extends Thread{
        private final String name;

        public Task5(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name);
            }
        }

        public static void main(String[] args) {
            Thread thread1 = new Task5("Thread 1");
            Thread thread2 = new Task5("Thread 2");
            Thread thread3 = new Task5("Thread 3");

            thread1.start();
            thread2.start();
            thread3.start();
        }
}
