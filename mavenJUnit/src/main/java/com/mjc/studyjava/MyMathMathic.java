package com.mjc.studyjava;

public class MyMathMathic {
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
}