package q0502;


import java.util.Arrays;

//조건에 맞게 수열 변환하기 1
public class Test2 {

    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 100, 99, 98});
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] = arr[i] / 2;
            } else if (arr[i] < 50 && (arr[i] % 2 != 0)){
                arr[i] = arr[i] * 2;
            }
        }

        return arr;
    }
}
