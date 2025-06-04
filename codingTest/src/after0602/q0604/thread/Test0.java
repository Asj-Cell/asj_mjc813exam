package after0602.q0604.thread;

public class Test0 {


    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread thread = new Thread(test, "Test_Thread");
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("["+Thread.currentThread().getName()+"] :반복 실행 "+(i+1)+"번째");
            Thread.sleep(1000);
        }
    }
    static class Test implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i <5 ; i++) {
                System.out.println("["+Thread.currentThread().getName()+"] :반복 실행 "+(i+1)+"번째");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
