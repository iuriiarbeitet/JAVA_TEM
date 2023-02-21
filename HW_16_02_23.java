package HomeWork_Tasks;

import java.util.ArrayList;
import java.util.Arrays;


public class HW_16_02_23 {

    public static int[] arr = {1, 1, 2, 2, 4, 4, 3, 5, 5, 6, 6, 7, 7};
    public static int[] arr2 = {1, 0, 2, 8, 6, 5, 4, 7};

    public static void main(String[] args) {
//        System.out.println(noPar(arr));
//        System.out.println(getMissingNumber(arr2));
//        System.out.println(getOwnDivisors(129));
        genDimArr(7, 7);
    }
    /*
    1. Описание занятия: 1. Дан массив чисел в котором все числа имеют повторения, кроме одного числа. Найти это число
     */
    public static int noPar(int[] arr){
        int p = -1;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j] && (i != j)) {
                        flag = true;
                    }
                }
                if (!flag) p = arr[i];
                flag = false;
        }
        return p;
    }


    /* 2. Описание занятия:
    Дан массив чисел, в котором есть все числа от 0 до N . Все эти числа в единственном экземпляре.
Расположены в разнобой. Одно число в этом массиве пропущено ( Например {1 0 2 8 6 5 4 7} - это 3 ) .
Найти пропущенное число
     */
    public static int getMissingNumber (int[] arr2) {
        int num = -1;
        boolean flag = false;
        for (int k : arr2) {
            for (int j = 0; j < arr2.length; j++) {
                if (k - 1 == arr2[j]) {
                    flag = true;
                }
            }
            if (!flag) {
                num = k - 1;
            }
            flag = false;
        }
        return num;
    }

/* 3. Описание занятия: Дан массив чисел. Найти число состоящее из собственных делителей.
Например число 128 состоит из 1 2 и 8. 128 % 1 == 0 , 128 % 2 == 0 и 128 % 8 == 0. Вот такие числа надо найти.*/

    public static ArrayList<Integer> getOwnDivisors (int num) {
//        int[] divisors = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> ownDivisors = new ArrayList<>();
//        for (int i = 0; i < divisors.length; i++) {
//            if (num % divisors[i] == 0){
//                ownDivisors.add(divisors[i]);
//            }
//        }
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int divisors = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(num % divisors == 0) {
                ownDivisors.add(divisors);
            }
        }
        return  ownDivisors;
    }

    /* 4. Описание занятия: Ну и для особо отличившихся. Написать метод который
        генерирует двумерный массив длиной N и высотой H
     Далее заполняет получившийся массив числами от 1 до W по спирали.
        Например массив [ ][ ][ ][ ]
                        [ ][ ][ ][ ]
                        [ ][ ][ ][ ]
                имеет N == 4 and H == 3 и вид [ 1 ][ 2 ][ 3 ][ 4 ]
                                              [10][11][12 ][ 5 ]
                                              [ 9 ][ 8 ][ 7 ][ 6 ]
*/
    public static void genDimArr(int h, int w){
        int num = 1;
        int count1 = -1;
        int[][] dimArr = new int[h][w];

        for (int k = h; k >= 0; k--) {
            count1++;
                    for (int i = count1; i < h -count1; i++) {
                        for (int j = count1; j < w - count1; j++) {
                            if (i == count1) {
                                dimArr[i][j] = num++;
                            }
                            if(count1 == w/2) break;
                            if (i < h - 1 - count1 && i > count1 && j == w - 1 - count1) {
                                dimArr[i][j] = num++;
                            }
                            if (i == h - 1 - count1){
                               dimArr[i][w - 1 - j] = num++;
                                if (i == count1) break;
                            }
                        }
                    }
                    for (int i = h-1 - count1; i > count1; i--) {

                        for (int j = count1; j < w - count1; j++) {
                            if(count1 == w/2) break;
                            if (i > count1 && i < h - 1 - count1 && j == count1){
                                dimArr[i][j] = num++;
                           }
                        }
                    }
            if (h == 3) {
                for (int i = 1; i == 1; i++) {
                    for (int j = 0; j < dimArr[i].length; j++) {
                        if (j < dimArr[i].length-1-1)
                        dimArr[1][j+1] = num++;
                    }
                }
                k = 0;
            }
    }
//        for (int i = 0; i < dimArr.length; i++) {
//            for (int j = 1; j < dimArr[i].length-1; j++) {
//                if (i % 2 != 0 && i < dimArr.length-1 && j < dimArr[i].length-1){
//                    dimArr[i][j] = num++;
//                }else if (i > 1 && i < dimArr.length-1 && j < dimArr[i].length-1){
//                    dimArr[i][dimArr[i].length - 1 - j] = num++;
//                }
//                }
//
//        }
        for (int i = 0; i < dimArr.length; i++) {
            System.out.println(Arrays.toString(dimArr[i]));
        }
    }


}
