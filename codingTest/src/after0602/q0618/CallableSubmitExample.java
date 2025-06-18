package after0602.q0618;

import java.util.concurrent.*;

public class CallableSubmitExample  {

    public static void main(String[] args) {
        Long ms = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(5);
        ISumLoopIm is = new ISumLoopIm();

        for ( int i = 1; i <= 100000; i++ ) {
            final int idx = i;
            es.execute(() -> {
                Long sum = 0L;
                for (int j = 1; j <= idx; j++) {
                    sum += j;
                }
                is.print(sum);
            });
        }

        ms = System.currentTimeMillis() - ms;
        System.out.printf("totalMills = %d ms\n", ms);
        es.close();
    }


}

