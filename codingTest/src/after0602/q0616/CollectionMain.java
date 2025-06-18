package after0602.q0616;

import java.sql.Time;
import java.util.*;

public class CollectionMain {
        Set set;

    public static void main(String[] args) {
//        TimeTest(new ArrayList<>());
//        TimeTest(new LinkedList<>());
//
//        15장의 예제들을 본인이 직접 소스 개발 해보세요. (클래스를 별도로 만들필요 없이 Chapter15 클래스의 메소드로 추가해도된다.)
//        15장의 확인문제 소스를 직접 풀어보세요.
//        6월13일 문제의 Computer 클래스를 HashSet 에 저장할때 키를 무엇으로 할지 결정하고 저장해보세요
//        6월13일 문제의 Computer 클래스를 TreeMap 에 5월16일 자료를 저장할때 자동으로 정렬되는것을 확인해보세요.
        TreeMap<String, String> list = new TreeMap<>();
        list.put("d", "a");
        list.put("c", "b");
        list.put("b", "c");
        list.put("a", "d");
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.poll();
        System.out.println(list);
        NavigableMap<String, String> newList = list.descendingMap();
        System.out.println(newList);
        List<Integer> lliisstt = Arrays.asList(1, 2, 3);
        System.out.println(lliisstt);


        HashSet<Integer> integerSet = new HashSet<>();
        integerSet.add(null);
        System.out.println(integerSet);
    }

    public static void TimeTest(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        System.out.println(list.getClass());
        for (int i = 0; i < 50_000; i++) {
            list.add(list.size()/2 , i);
        }
//        for (int i = 0; i < 50_000; i++) {
//            list.addFirst(i);
//        }
//        for (int i = 0; i < 50_000; i++) {
//            list.add(i);
//        }
        long endTime = System.currentTimeMillis();
        System.out.println("걸린시간: " + (endTime - startTime) + "ms");


    }
}
