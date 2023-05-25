package org.example;

public class Test extends Thread{
    private String message;

    public Test(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        Task8_Printer.print(message);
    }
}
