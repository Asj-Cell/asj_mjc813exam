package q0502;

// 평행
public class Test9 {

    public static void main(String[] args) {
        int result = solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}});
        System.out.println(result);
    }


    public static int solution(int[][] dots) {
        if (gradient(dots[0], dots[1]) == gradient(dots[2], dots[3])) {
            return 1;
        } else if (gradient(dots[0], dots[2]) == gradient(dots[1], dots[3])) { // 이 경우는 대각선이여서 없어도 될듯
            return 1;
        } else if (gradient(dots[0], dots[3]) == gradient(dots[1], dots[2])) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double gradient(int[] arr1, int[] arr2) {
        return (arr2[1] - arr1[1]) * 1.0 / (arr2[0] - arr1[0]);
    }
}
