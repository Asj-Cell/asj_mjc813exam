package after0602.q0619;

import java.util.LinkedList;
import java.util.List;

public class StreamMain {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("A","B","C","D","E","F","G","H","I","J","K"));

        list.stream()
                .parallel()
                .forEach(s-> System.out.println(Thread.currentThread().getName()+s));

    }



}
