package q0502;

import java.util.Arrays;


//x 사이의 개수
public class Test3 {

    public static void main(String[] args) {
        String[] result = solution("oxooxoxxox");
        System.out.println("result = " + Arrays.toString(result));
    }

    public static String[] solution(String myString) {
        String[] intArray={};
        int length = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                length++;
            }
            intArray = myString.split("x", length + 1);
        }
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = intArray[i].length() + "";
        }
        return intArray;
    }
}
