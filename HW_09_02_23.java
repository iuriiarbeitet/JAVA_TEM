package HomeWork_Tasks;

import java.util.ArrayList;

public class HW_09_02_23 {

    public static void main(String[] args) {
        int[] arr = {0 ,1, 4, 5, 8, 9, 3, 2, 6};  // n = 13;
        int[] nums = {1, 1, 5, 4, 1, 9, 2, 4, 6}; // n = 11;
        getTwoNumbers(arr, 13);
        System.out.println(isDuplicated(nums));
        System.out.println(getMinSequence(nums, 11));

    }
    public static void getTwoNumbers(int[] arr, int n) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        //Дан массив и число n
        //Вывести на экран два любых числа из массива которые
        //в сумме дают n за O(n) либо написать что таких чисел нет
        //[0 1 5 4 8 9 3 2 6] n = 13
        //** все пары чисел
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    a.add(arr[i]);
                    b.add(arr[j]);
                }
            }
        }
        if (a.get(0) + b.get(0) == n) {
            System.out.println("First number is: " + a);
            System.out.println("Second number is: " + b);
        } else System.out.println("\"Sorry\", в данам массиве таких чиселнет");
    }
    public static boolean isDuplicated(int[] nums) {
        //вам необходимо проверить массив на наличие повторений чисел
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    flag = true;
                }
            }
        }
        return flag;
    }
    public static int getMinSequence(int[] nums, int n) {
        int minSeq = 0;
        //[1 1 5 4 1 9 2 4 6] n = 11
        //вернуть длину минимальной последовательности
        //которая в сумме дает n
        //в массиве все числа положительные
        int sum = 0;
        int conter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum < n) {
                    sum = sum + nums[j];
                    conter++;
                } else if (sum == n) {
                    minSeq = conter;
                    if (minSeq > conter) {
                        minSeq = conter;
                    }
                    sum = 0;
                    conter = 0;
                } else if (sum > n) {
                    sum = 0;
                    conter = 0;
                }
            }
        }
        return minSeq;
    }
}
