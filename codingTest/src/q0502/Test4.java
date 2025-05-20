package q0502;

// 암호해독
public class Test4 {

    public static void main(String[] args) {
        String result = solution("dfjardstddetckdaccccdegk", 4);
        System.out.println("result = " + result);
    }

    public static String solution(String cipher, int code) {
        String answer = "";

        for (int i = 1; i <= cipher.length(); i++) {

            if (i % code ==0) {
                answer += cipher.charAt(i-1);
            }

        }

        return answer;
    }
}
