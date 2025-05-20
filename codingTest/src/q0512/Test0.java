package q0512;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test0 {
    public static void main(String[] args) {
        String repeat = "Hello".repeat(5);
        System.out.println(repeat);


        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "world");
        String s = map.get("hello");
        System.out.println(map);
        System.out.println(s);


    }
}
