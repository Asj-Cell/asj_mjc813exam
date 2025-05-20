import java.util.ArrayList;
import java.util.Collections;

public class Test2 {
    private static final ArrayList<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        int size=0;
        while (size != 6) {
            int number = (int) (Math.random() * 45) + 1;

            if (isEquals(number)) {
                numList.add(number);
                size++;
            }
        }

        Collections.sort(numList);
        System.out.println(numList);

    }

    private static boolean isEquals(int number) {
        for (int i = 0; i < numList.size(); i++) {
            if (number == numList.get(i)) {
                return false;
            }
        }
        return true;
    }
}
