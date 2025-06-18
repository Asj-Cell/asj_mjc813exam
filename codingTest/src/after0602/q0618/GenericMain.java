package after0602.q0618;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class GenericMain {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer resultList = list.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);


        System.out.println(resultList);


    }
}
