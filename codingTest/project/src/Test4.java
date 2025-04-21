import java.util.*;

public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("단어들을 입력하시오. (공백으로 구분)");
        String strings = scanner.nextLine();
        String[] words = strings.split(" ");
        int max=0;
        String str = "";




        for (String word : words) {
            Integer count = map.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(word, count);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int comep = entry.getValue();
            if (comep > max) {
                max=comep;
                str = entry.getKey();
            }
        }
        System.out.println(str+max);
    }


}
