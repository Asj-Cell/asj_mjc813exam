package com.mjc.studyjava;

import java.math.BigDecimal;

public class Test0 {


    public static void main(String[] args) {

        String s = MyMathMathicV3.makeEncryptString("mjc813", 5);
        System.out.println(s);
        String s1 = MyMathMathicV3.makeDecryptString("A8dkIm8Tkd4jKLi9hcu4Rsa893saw1kszNm3", 5);
        System.out.println(s1);
        int total=0;
        int a = 90;
        for (int i = a; i <= 100; i++) {
            total += i;
        }
        System.out.println(total);

        BigDecimal bigDecimal = MyMathMathicV3.getBigDecimal(3643, 5630932);
        System.out.println(bigDecimal);
        int i =0;

    }
}
