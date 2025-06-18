package after0602.q0618;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class TestTest {

    private static AtomicLong totalOverallSum = new AtomicLong(0);

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 100000; i++) {
            final int idx = i;

            Runnable task = () -> {
                long sum = 0L;
                for (int j = 1; j <= idx; j++) {
                    sum += j;
                }
                Thread thread = Thread.currentThread();

                totalOverallSum.getAndAdd(sum);
            };

            executorService.execute(task);
        }

        Long submitEndTime = System.currentTimeMillis();
        System.out.printf("모든 태스크 제출 완료까지 걸린 시간 = %d ms\n", (submitEndTime - startTime));

        executorService.shutdown();

        Long totalExecutionEndTime = System.currentTimeMillis();
        System.out.printf("걸린 시간 = %d ms\n", (totalExecutionEndTime - startTime));
        System.out.printf("모든 태스크 합계의 총합 (확인용) = %d\n", totalOverallSum.get());
    }
}
