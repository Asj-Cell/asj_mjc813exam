package q0502;


import java.util.ArrayList;
import java.util.Arrays;

// 배열 만들기 3
public class Test8 {

    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 4}});
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] interval : intervals) {

            for (int i = interval[0]; i <= interval[1]; i++) {
                list.add(arr[i]);
            }
        }
        int[] answerArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answerArray[i] = list.get(i);
        }
        return answerArray;
    }
}
