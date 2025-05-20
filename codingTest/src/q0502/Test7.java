package q0502;


import java.util.Arrays;

// 접미사 배열
public class Test7 {


    public static void main(String[] args) {
        String[] result = solution("banana");
        System.out.println("result = " + Arrays.toString(result));
    }

    public static String[] solution(String my_string) {
        String[] strArray = new String[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            strArray[i] = "";
            for (int j = i; j < my_string.length(); j++) {
                strArray[i] += my_string.charAt(j);
            }
        }

        Arrays.sort(strArray);
        return strArray;
    }
}
