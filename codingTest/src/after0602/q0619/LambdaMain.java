package after0602.q0619;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaMain {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> resultList = list.stream()
                .filter(n -> n % 2 != 0)
                .toList();
        System.out.println(resultList);

        List<Integer> list1 = list.stream()
                .flatMap(n -> Stream.of(n))
                .toList();
        System.out.println(list1);


        int result = list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * 10)
                .findAny()
                .orElse(0);
        System.out.println(result);

//        list.stream()
//                .parallel()
//                .forEach(System.out::println);
        // 1. Runtime.getRuntime().availableProcessors() 확인 (기본 스레드 수에 영향)
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());

        // 2. ForkJoinPool.commonPool()을 통해 현재 Common Pool의 속성 확인
        System.out.println("ForkJoinPool Common Pool Parallelism: " + commonPool.getParallelism());
        System.out.println("ForkJoinPool Common Pool Pool Size: " + commonPool.getPoolSize());
        System.out.println("ForkJoinPool Common Pool Active Thread Count: " + commonPool.getActiveThreadCount());
        System.out.println("ForkJoinPool Common Pool Running Thread Count: " + commonPool.getRunningThreadCount());

    }
}
