package HomeWork_Tasks;

import java.util.Arrays;

public class Spirali_HW {
          public static void main(String[] args) {
            getSpirali_EX_01(7, 7);
            getSpitali_EX_03(3,7);

        }

        public static void getSpirali_EX_01(int h, int w) {
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
    }


