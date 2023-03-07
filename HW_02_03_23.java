package HomeWork_Tasks;

import Lessons._2023_02_28.LIE;

import java.util.*;

public class HW_02_03_23 {
    /**
     * Описание задания.
     *
     *  Описание задания :
     * Написать класс который содержит ArrayList и методы:
     *      1) заполняют лист рандомными цифрами
     *      2) перебирают Итератором и выводят на экран все четные
     *      3) перебирают итератором и выводят на экран все нечетные
     *      4) генерируют рандомную стрингу длиной 5
     *      5) перебираю итератором эту стрингу с конца и выводит тот символ который нужен если он есть,
     *      если нет то выдает сообщение
     */

    private static final ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10, 9,12));

    public static void main(String[] args) {
        System.out.println(randArrList(10, 10));
        System.out.println("четные: " + printEvenNumber(arrayList));
        System.out.println("нечетные: " + printOddNumber(arrayList));
        System.out.println("рандомная стринга: " + generatorString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5));
        findChar('A');
    }

    // 1) заполняют лист рандомными цифрами:
    public static ArrayList<Integer> randArrList(int xAdd, int xRand){
        ArrayList<Integer> arrayList = new ArrayList<>(xAdd);
        Random random = new Random();
        for (int i = 0; i < xAdd; i++) {
            arrayList.add(i, random.nextInt(xRand));
        }
        return arrayList;
    }
    // 2) перебирают Итератором и выводят на экран все четные:
    public static ArrayList<Integer> printEvenNumber(ArrayList<Integer> nums){
        Iterator<Integer> it = nums.iterator();
        ArrayList<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            int tmp = it.next();
            if (tmp % 2 == 0) {
                result.add(tmp);
            }
        }
        return result;
    }

    //  3) перебирают итератором и выводят на экран все нечетные:

    public static ArrayList<Integer> printOddNumber(ArrayList<Integer> nums){
        Iterator<Integer> it = nums.iterator();
        ArrayList<Integer> result = new ArrayList<>();
        while (it.hasNext()) {
            int tmp = it.next();
            if (tmp % 2 != 0) {
                result.add(tmp);
            }
        }
        return result;
    }

    // 4) генерируют рандомную стрингу длиной 5 :
                        // "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    public static  String generatorString (String s, int lengthWord){
        Random random = new Random();
         String str = "";
            StringBuffer sb = new StringBuffer(s.length());
            for (int j = 0; j < lengthWord; j++) {
                sb.append(s.charAt(random.nextInt(s.length())));
            }
            str = sb.toString();
        return str;
    }

    //  5) перебираю итератором эту стрингу с конца и выводит тот символ который нужен если он есть,
    //     *      если нет то выдает сообщение :
    public static void findChar (char chSearch){
        ArrayList<Character> arrayList1 = new ArrayList<>();
        String str = generatorString("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5);
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            arrayList1.add(str.charAt(i));
        }
          ListIterator<Character> listIterator = arrayList1.listIterator(arrayList1.size());
           boolean flag = false;
            char ch = ' ';
            char tmp = ' ';
            int countPosition = str.length()+1;
            while (listIterator.hasPrevious()) {
                ch = listIterator.previous();
                countPosition--;
                if (chSearch == ch) {
                    flag = true;
                    tmp = ch;
                    break;
                }
            }
            if (flag) {
                System.out.println(tmp + " position in string: " + countPosition);
            } else {
                System.out.println("Character " + chSearch + " not found...");
            }
    }
}
