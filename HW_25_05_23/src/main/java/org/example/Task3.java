package org.example;

/**
 * 3. Задача:
 * Создайте 2 потока, которые выводят все четные числа от 1 до 20 и все
 * нечетные числа от 1 до 20 соответственно. Каждый поток должен использовать
 * метод run() для вывода чисел.
 */
public class Task3 extends Thread {

        private static final Object lock = new Object();
       private final boolean isEven;

        public Task3(boolean isEven) {
            this.isEven = isEven;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 20; i++) {
                    if(isEven){
                        if(i % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ": " + i);
                        }
                    } else {
                        if(i % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + ": " + i);
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            Thread evenThread = new Task3(true);
            Thread oddThread = new Task3(false);

            evenThread.start();
            oddThread.start();
        }
    }

