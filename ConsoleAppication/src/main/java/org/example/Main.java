package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Main {

        public static void main(String[] args) {
            try {
                long result1 = 10L / 4;
                System.out.println("10L / 4 = " + result1);

                long result2 = 10L / 2;
                System.out.println("10L / 2 = " + result2);

                long result3 = 10L / 0; // Здесь будет выброшено ArithmeticException
                System.out.println("10L / 0 = " + result3);
            } catch (ArithmeticException e) {
                String errorMessage = "Exception occurred: " + e.getMessage();
                writeErrorMessageToFile(errorMessage);
            }
        }

        private static void writeErrorMessageToFile(String errorMessage) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("err.log"))) {
                writer.println(errorMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}