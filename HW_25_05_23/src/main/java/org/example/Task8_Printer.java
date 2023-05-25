package org.example;

/**
 * 8. Задача:
 * Создайте класс Printer, у которого есть метод print(String message),
 * который должен выводить сообщение посимвольно с задержкой в 100 миллисекунд.
 * Создайте два потока, каждый из которых вызывает метод print() с разными сообщениями.
 * Используйте синхронизированный блок внутри метода print(),
 * чтобы гарантировать последовательную печать символов сообщений.
 */
public class Task8_Printer {
    private static final Object object = new Object();
        public static void print(String message) {
            synchronized (object) {
                for (int i = 0; i < message.length(); i++) {
                    System.out.print(message.charAt(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println();
        }
        public static void main(String[] args) {

            Thread thread1 = new Thread(() -> Task8_Printer.print("Hello"));
            Thread thread2 = new Thread(() -> Task8_Printer.print("People"));

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
