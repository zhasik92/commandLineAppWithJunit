package playgroung.tutorial.synchronizers;

import java.util.concurrent.CountDownLatch;

public class LatchExamples {
    private static final int nTasks = 22;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(nTasks);
        for (int i = 0; i < nTasks; i++) {
            new Thread(new Task(startLatch, endLatch, i)).start();
        }
        Thread.sleep(2000);
        System.out.println("start latch fired");
        startLatch.countDown();
        System.out.println("waiting end latch");
        endLatch.await();
        System.out.println("work is done");
    }


}
