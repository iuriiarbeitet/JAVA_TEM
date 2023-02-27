package HomeWork_Tasks;

import java.util.ArrayList;
import java.util.Arrays;


public class HW_16_02_23 {

    public static int[] arr = {1, 1, 2, 2, 4, 4, 3, 5, 5, 6, 6, 7, 7};
    public static int[] arr2 = {-2,-1,1, 0, 2,3, 8, 6, 5, 4, 7};

    public static void main(String[] args) {
        System.out.println(noPar(arr));

        System.out.println(getMissingNumber(arr2));

        System.out.println(getOwnDivisors(256));
        getSpitali_EX_03(5,10);
        genDimArr(10, 5);

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
    public static String getMissingNumber (int[] arr2) {
        String num = "not found number";
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        boolean flag = false;
        for (int k : arr2) {
            for (int j = 0; j < arr2.length; j++) {
                if (k - 1 == arr2[j]) {
                    flag = true;
                }
                if (min > arr2[j]) min = arr2[j];
            }
            if (!flag && (k-1 > min)) {
                 num = String.valueOf(k - 1);
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
    public static void getSpitali_EX_03 (int h, int w) {
        int num = 1;
        int[][] arr = new int[h][w];

        int count = -1;

        int flag = 0;
        if (h > w) flag = h;
        else flag = w;

        for (int k = 0; k < flag / 2 + 1; k++) {
            count++;
            int j_oben = 0 + count;
            int j_right = w - 1 - count;
            int j_unter = h - 1 - count;
            int j_left = 0 + count;

            for (int i = 0 + count; i <= w - 1 - count; i++) {
                arr[j_oben][i] = num++;
            }
            if (count == h / 2) break;
            for (int i = 1 + count; i < h - 1 - count; i++) {
                arr[i][j_right] = num++;
            }
            for (int i = w - 1 - count; i - count >= 0; i--) {
                arr[j_unter][i] = num++;
            }
            if (count == w / 2) break;
            for (int i = h - 1 - count - 1; i - count > 0; i--) {
                arr[i][j_left] = num++;
            }
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void genDimArr(int h, int w){
        int[][] arr = new int[h][w];
        int num = 1;
        int flag = 0;
        if (h < w) flag= h;
        else flag = w;

        int count = -1;
        for (int x = 0; x <= flag/2; x++) { //запуск рекурсии...
            count++;

            // заполнение нулевого ряда.
            for (int i = count; i < arr.length-count ; i++) {
                if (i == count) {
                    for (int j = count; j < arr[i].length-count; j++) {
                        arr[i][j] = num++;
                    }
                }
            }
            if (count == h / 2) break;
// заполнение правой стороны массива сверху вниз
            for (int i = count; i < arr.length-count ; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i > count && i < arr.length - 1 - count && j == arr[i].length - 1 - count) {
                        arr[i][j] = num++;
                    }
                }
            }
// заполнение нижнего ряда массива справа налево.
            for (int i = count; i < arr.length-count ; i++) {
                if (i == arr.length - 1 - count) {
                    for (int j = count; j < arr[i].length - count; j++) {
                        arr[i][arr[i].length - 1 - j] = num++;
                    }
                }
            }

            if (count == w / 2) break;
// заполнение левой части массива снизу в верх..
            for (int i = count; i < arr.length-count ; i++) {
                if (i == arr.length - 1 - count) {
                    for (int k = 1; k < arr.length - 1 - count - count; k++) {
                        arr[arr.length - 1 - k - count][count] = num++;
                    }
                }
            }
        }
        // вывод результата...
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
      }


}
