package org.example;

/**
 * 4. Задача:
 * Создайте 4 потока, которые выводят сообщение "Hello, World!" каждый с задержкой в 1 секунду.
 *  Каждый поток должен использовать метод run() для вывода сообщения.
 */
public class Task4 extends Thread{

    private static final Object object = new Object();

        @Override
        public void run() {
            synchronized (object) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Hello, World!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            for (int i = 1; i <= 4; i++) {
                Thread thread = new Task4();
                thread.start();
            }
        }

}
