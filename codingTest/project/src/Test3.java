import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;


public class Test3 {


    public static void main(String[] args) {
        String[] strArrays = {"aya", "yee","u" ,"maa", "wyeoo"};
        int result = input(strArrays);
        System.out.println(result);

    }




    public static int input(String[] inputs) {
        String[] strs = {"aya","ye","woo","ma"};
        int num=0;
        for (String input : inputs) {
            for (String str : strs) {
                input=input.replaceAll(str, "0");
            }
            if (input.replaceAll("0", "").equals("")) {
                num++;
            }
        }

        return num;
    }

}
