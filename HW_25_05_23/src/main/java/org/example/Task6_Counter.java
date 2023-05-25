package org.example;

/**
 * 6. Задача:
 * Создайте класс Counter, который имеет внутреннее целочисленное поле count.
 * Создайте два потока, каждый из которых увеличивает count на 1 миллион раз.
 * Используйте синхронизированный блок, чтобы гарантировать корректное обновление значения count
 */
public class Task6_Counter extends Thread{
    private static final Object object = new Object();
            private int count;

        public Task6_Counter() {
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            synchronized (object) {
                for (int i = 0; i < 1_000_000; i++) {
                    count++;
                }
            }
        }

        public static void main(String[] args) {
            Task6_Counter counter = new Task6_Counter();

            Thread thread1 = new Thread(counter::increment);

            Thread thread2 = new Thread(counter::increment);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final count: " + counter.getCount());
        }
    }

