package org.example;

/**
 * 9. Задача:
 * Создайте класс SharedResource, у которого есть целочисленное поле value.
 *  Создайте три потока, один из которых устанавливает значение value,
 *   а два других потока пытаются получить это значение.
 *   Используйте синхронизированный блок и метод wait() и notify() для синхронизации потоков.
 */
public class Task9_SharedResource {
        private int value;
        private boolean valueSet;

        public synchronized void setValue(int newValue) {
            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            value = newValue;
            valueSet = true;
            System.out.println("Value set: " + value);
            notifyAll();
        }

        public synchronized int getValue() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int actualValue = value;
            valueSet = false;
            System.out.println("Value retrieved: " + actualValue);
            notifyAll();
            return actualValue;
        }

        public static void main(String[] args) {
            Task9_SharedResource sharedResource = new Task9_SharedResource();

            Thread setValueThread = new Thread(() -> {
                sharedResource.setValue(42);
            });

            Thread getValueThread1 = new Thread(() -> {
                int value = sharedResource.getValue();
                System.out.println("Received value: " + value);
            });

            Thread getValueThread2 = new Thread(() -> {
                int value = sharedResource.getValue();
                System.out.println("Received value: " + value);
            });

            setValueThread.start();
            getValueThread1.start();
            getValueThread2.start();

            try {
                setValueThread.join();
                getValueThread1.join();
                getValueThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
