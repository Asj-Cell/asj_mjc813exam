package q0502;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//카운트 다운
public class Test5 {

    public static void main(String[] args) {
        int[] result = solution(10	,3);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int start_num, int end_num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start_num; i >= end_num; i--) {
            list.add(i);
        }
        int[] newArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }

        return newArray;
    }
}
