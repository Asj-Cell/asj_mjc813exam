package after0602.q0605;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test1 {

    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1~100 까지의 합: "+sumThread.getSum());

    }

    static class SumThread extends Thread{

        private long sum;

        public long getSum() {
            return sum;
        }

        public void setSum(long sum) {
            this.sum = sum;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100 ; i++) {
                sum += i;
            }
        }
    }
}
