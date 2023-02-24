package HomeWork_Tasks;

import java.util.Arrays;

public class Spirali_HW {
          public static void main(String[] args) {
            zmei(9, 10);

        }

        public static void zmei(int h, int w) {
            int[][] arr = new int[h][w];
            int num = 1;
            int flag = 0;
            if (h < w) flag= h;
            else flag = w;

            int count = -1;
            for (int x = 0; x <= flag/2; x++) {
                count++;
                   for (int i = count; i < arr.length-count ; i++) {

                       if (i == count) {
                    for (int j = count; j < arr[i].length-count; j++) {
                        arr[i][j] = num++;
                    }
                    }
                   }

                if (count == h / 2) break;

                for (int i = count; i < arr.length-count ; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (i > count && i < arr.length - 1 - count && j == arr[i].length - 1 - count) {
                            arr[i][j] = num++;
                        }
                    }
                }

                for (int i = count; i < arr.length-count ; i++) {
                    if (i == arr.length - 1 - count) {
                        for (int j = count; j < arr[i].length - count; j++) {
                            arr[i][arr[i].length - 1 - j] = num++;
                        }
                    }
                }

                if (count == w / 2) break;

                for (int i = count; i < arr.length-count ; i++) {
                    if (i == arr.length - 1 - count) {
                        for (int k = 1; k < arr.length - 1 - count - count; k++) {
                            arr[arr.length - 1 - k - count][count] = num++;

                        }
                    }
                }



            }

            for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
        }
    }


