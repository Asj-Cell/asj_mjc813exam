package q0502;

import java.util.Arrays;


//x 사이의 개수
public class Test3 {

    public static void main(String[] args) {
        int[] result = solution("oxooxoxxox");
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(String myString) {
        String[] strArray={};
        int length = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                length++;
            }
            strArray = myString.split("x", length + 1);
        }
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].length()+"";
        }

        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }
}
