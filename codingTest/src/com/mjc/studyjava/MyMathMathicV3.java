package com.mjc.studyjava;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class MyMathMathicV3 {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static long mul(int a, int b) {
        return (long) a * b;
    }

    public static int divM(int a, int b) {
        return a / b;
    }

    public static int divN(int a, int b) {
        return a % b;
    }

    public static boolean same(int a, int b) {
        return a == b;
    }

    public static boolean same(String a, String b) {
        if (a==null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    public static boolean notsame(int a, int b) {
        return a != b;
    }

    public static boolean big(int a, int b) {
        return a > b;
    }

    public static boolean small(int a, int b) {
        return a < b;
    }

    public static int shiftLeft(int a, byte b) {
        return a << b;
    }

    public static int shiftRight(int a, byte b) {
        return a >> b;
    }

    public static int shiftRight0(int a, byte b) {
        return a >>> b;
    }

    public static long square(int a, byte b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static int absolute(int a) {
        return Math.abs(a);
    }

    public static String toHex(int a) {
        return Integer.toHexString(a);
    }

    public static String toBin(int a) {
        return Integer.toBinaryString(a);
    }

    public static String toOct(int a) {
        return Integer.toOctalString(a);
    }

    public static int toDec(String a) {
        if (a == null) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public static int avg(int [] values){
        if (values == null) {
            return 0;
        }
        int total =0;
        for (int value : values) {
            total += value;
        }
        return total / values.length;
    }

    public static int sum(int[] values) {
        if (values == null) {
            return 0;
        }
        int total=0;
        for (int value : values) {
            total += value;
        }
        return total;
    }
    public static int sumOfNumber(int [] values, int number) {
        if (values == null) {
            return 0;
        }
        int total=0;
        for (int value : values) {
            if (value % number == 0) {
                total += value;
            }
        }
        return total;
    }
    public static int sumOfLoop(int a, int b) {
        int total=0;
        for (int i = a; i <= b; i++) {
            total += i;
        }
        return total;
    }

    public static int sumOfFav(int a, int b) {
        if (a > b) {
            return 0;
        }
        return a + sumOfFav(a + 1, b);
    }

    public static BigDecimal getBigDecimal(int n, int s){
        return new BigDecimal(n + "." + s);


    }

    public static Integer[] getIntegerArray(int[] array){
        if (array == null) {
            return null;
        }
        Integer[] arrayStream = Arrays.stream(array)
                .boxed()
                .toArray(Integer[]::new);

//        Integer[] integerArray = new Integer[array.length];
//        for (int i = 0; i < array.length; i++) {
//            integerArray[i] = array[i];
//        }
        return arrayStream;
    }

    public static int[] makeRandomIntArray(int n) {
        int[] randoms = new int[n];
        for (int i = 0; i < n; i++) {
            randoms[i] = (int) (Math.random() * 6) + 1;
        }
        return randoms;
    }
    public static String makeEncryptString(String text, int n) {
        if (text == null) {
            return "";
        }
        String array = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder sb = new StringBuilder();
        int iter=0;
        if (n >= 5) {
            for (int i = 1; i <= (text.length() * n); i++) {
                if (i % n == 0) {
                    sb.append(text.charAt(iter));
                    iter++;
                    continue;
                }
                int selectNum = (int) (Math.random() * array.length());
                sb.append(array.charAt(selectNum));
            }
        }
        return sb.toString();
    }

    public static String makeDecryptString(String code, int n) {
        if (code == null) {
            return "";
        }
        StringBuilder newString = new StringBuilder();

        for (int i = 1; i <= code.length(); i++) {
            if (i % n == 0) {
                newString.append(code.charAt(i - 1));
            }
        }
        return newString.toString();
    }

}
