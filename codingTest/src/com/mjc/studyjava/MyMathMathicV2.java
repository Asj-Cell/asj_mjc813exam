package com.mjc.studyjava;

public class MyMathMathicV2 {

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
        return a.equals(b);
    }

    public static boolean notSame(int a, int b) {
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
        return Integer.parseInt(a);
    }

    public static int avg(int [] values){
        int total =0;
        for (int value : values) {
            total += value;
        }
        return total / values.length;
    }

    public static int sum(int[] values) {
        int total=0;
        for (int value : values) {
            total += value;
        }
        return total;
    }
    public static int sumOfNumber(int [] values, int number) {
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

//    int avg(int [] array) : int 배열 array 의 평균값을 리턴한다.
//    int sum(int [] array) : int 배열 array 의 총합계값을 리턴한다.
//    int sumOfNumber(int [] array, int number) : int 배열 array 의 원소중에서
//    n의 배수인 값의 총합계값을 리턴한다.
//    int sumOfLoop(int a, int b); a 부터 b 까지의 총합계값을 리턴한다. 루프제어를 사용한다.
//    int sumOfFav(int a, int b); a 부터 b 까지의 총합계값을 리턴한다. 재귀호출을 사용한다.
}
