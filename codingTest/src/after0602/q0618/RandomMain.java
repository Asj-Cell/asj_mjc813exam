package after0602.q0618;

import java.util.Random;

public class RandomMain {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomInteger = random.nextInt(6) + 1;
            System.out.println(randomInteger);
        }
    }
}
