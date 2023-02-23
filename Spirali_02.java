package HomeWork_Tasks;

import java.util.Arrays;

public class Spirali_02 {


        public static void main(String[] args) {
            zmei(15, 15);

        }

        public static void zmei(int h, int w) {
            int[][] arr = new int[h][w];
            int num = 1;
            int flag = 0;
            if (h < w) flag = h;
            else flag = w;

            int x = 0;
            int y = 0;

            int count =-1;

            for (int i = 0; i <= w/2; i++) {
                count++;
                x = count;
                y=count;

                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (x == count && y < w - count) arr[x][y++] = num++;
                if (count==h/2) break;
            x++;

            y = w-count;

            ///////////////////////////////////////////////
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;
                if (x > count && x < h - count && y == w - count) arr[x++][y-1] = num++;

                if (count==w/2) break;
//
                y = w-1-count;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;
                if (y > count && y - 1 < w - count) arr[x - 1][(y--)-1] = num++;

            x = h-1-count;
            y=count;
/////////////////////////
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;
                if (x-1 > count && x-1 < h - count && y == count) arr[(x--)-1][y] = num++;


        }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
        }
    }



