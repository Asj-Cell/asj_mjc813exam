package com.mjc.studyjava;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ComputerMain {

    public static void main(String[] args) {
//                - Contact 클래스에 Integer age 멤버변수를 추가한다.
//                - Contact 클래스 객체배열을 생성하고 배열 원소 5개 이상 추가한다. age 값도 생성자에서 저장되도록 추가한다.
//                - 객체배열의 stream() 을 이용하여 연락처 사람의 평균 나이를 계산한다.
        List<Computer> computerList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            computerList.add(new Computer("이름" + i, i + "", 8 + "", "500", Graphic.GTX_1660, 500 * i, i));
        }
//
//        int sum = computerList.stream()
//                .mapToInt(c -> c.getPrice() * c.getQty())
//                .sum();
//        System.out.println(sum);

        Integer result = computerList.stream()
                .map(c -> Integer.parseInt(c.getCpu()))
                .min((x, y) -> Integer.compare(x, y))
                .orElse(0);


        System.out.println(result);




    }
}
