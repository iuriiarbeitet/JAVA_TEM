package HomeWork_Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class HW_14_02_23 {
    //AAASSDDFFRRTGGBNHYUUU -> 3A2S2D2F2R1T2G1B1N1H1Y3U
    //**ДОБАВИТЬ ПРОВЕРКУ

    public static void main(String[] args) {
        System.out.println(getNewString("99AAASSDDFAAAFRRTGGBNHYUUU25"));
    }
    public static String getNewString(String s) {

        int count = 0;
        String s1 = "";
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alpha.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (!Character.isDigit((s.charAt(j)))) {
                    if (alpha.charAt(i) == s.charAt(j)) {
                        count++;
                    }
                }
            }
            if (count != 0) {
                s1 = s1 + count + alpha.charAt(i);
                count = 0;
            }
        }
        System.out.println(s1);
        return s1;
    }
}

