package q0502;

import java.util.Arrays;
import java.util.Collections;

// 최댓값 만들기 02
public class Test0 {

    public static void main(String[] args) {
        int result = solution(new int[]{1, 2, -3, 4, -5});
        System.out.println("result = " + result);
    }

    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        int nNum = numbers[0] * numbers[1];
        int pNum = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return Math.max(pNum, nNum);
    }
}
