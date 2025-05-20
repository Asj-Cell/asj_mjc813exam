package q0502;

//n보다 커질 때까지 더하기
public class Test1 {

    public static void main(String[] args) {
        int[] numbers = {34, 5, 71, 29, 100, 34};

        int result = solution(numbers, 123);
        System.out.println("result = " + result);


    }

    public static int solution(int[] numbers, int n) {
        int total =0;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
            if (total > n) {
                return total;
            }
        }
        return 0;
    }
}
