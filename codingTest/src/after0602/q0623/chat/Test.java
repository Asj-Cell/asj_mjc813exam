package after0602.q0623.chat;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));
        executorService.execute(()-> {
            int sum =0;
            for (int i = 50; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName()+" "+(sum += i));
            }
        });

        executorService.execute(()-> {
            int sum =0;
            for (int i = 1; i < 50; i++) {
                System.out.println(Thread.currentThread().getName()+" "+(sum += i));
            }
        });
        executorService.close();


    }
}
