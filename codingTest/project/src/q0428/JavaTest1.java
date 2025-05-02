package q0428;

import java.util.Arrays;

public class JavaTest1 {
    public static void main(String[] args) {
        int[][] result = solution(5);
        System.out.println("result = " + Arrays.deepToString(result));
    }

    public static int[][] solution(int n) {
        int[][] intArray = new int[n][n];
        return intArray;
    }

    public int goRight(int row,int[][] intArray, int start,int end,int number) {
        for (int i = start; i < end; i++) {
            intArray[row][i] = ++number;
        }
        return number;
    }
    public int goLeft(int row,int[][] intArray, int start,int end,int number) {
        for (int i = start; i >= end; i--) {
            intArray[row][i] = ++number;
        }
        return number;
    }
    public int goDown(int col,int[][] intArray, int start,int end,int number) {
        for (int i = start; i < end; i++) {
            intArray[col][i] = ++number;
        }
        return number;
    }
    public int goUp(int col,int[][] intArray, int start,int end,int number) {
        for (int i = start; i < end; i--) {
            intArray[i][col] = ++number;
        }
        return number;
    }
}
