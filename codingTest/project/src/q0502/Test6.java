package q0502;


import java.util.ArrayList;
import java.util.Arrays;


// 배열 만들기 1
public class Test6 {

    public static void main(String[] args) {
        int[] result = solution(10, 3);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % k == 0) {
                list.add(i);
            }
        }
        int[] newArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }
        return newArray;
    }
}
