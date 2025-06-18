package after0602.q0618;


public class StringBuilderTest {

    public static void main(String[] args) {


        StringTest();
    }

    private static void StringTest() {
//        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str = str + i;
        }
        long endTime = System.currentTimeMillis();


        System.out.println("걸린시간: " + (endTime - startTime) + "ms");
    }


}
