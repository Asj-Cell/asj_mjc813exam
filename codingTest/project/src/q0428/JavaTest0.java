package q0428;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaTest0 {

    public static void main(String[] args) {
        String result = stringIterator("Hello", 3);
        System.out.println("result = " + result);
        String[] strArrays = {"aya", "yee","u" ,"maa", "wyeoo"};
        int result1 = input(strArrays);
        System.out.println(result1);

    }

    public static String stringIterator(String str, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int input(String[] inputs) {
        String[] strs = {"aya", "ye", "woo", "ma"};
        int num = 0;
        for (String input : inputs) {
            for (String str : strs) {
                input = input.replace(str, "0");
            }
            if (input.replaceAll("0", "").equals("")) {
                num++;
            }
        }
        return num;
    }
}
