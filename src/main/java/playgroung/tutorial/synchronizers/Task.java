package playgroung.tutorial.synchronizers;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

class Task implements Runnable {
    private final CountDownLatch startLatch;
    private final CountDownLatch endLatch;
    private static final Random RANDOM = new Random();
    private final int threadId;

    public Task(CountDownLatch startLatch, CountDownLatch endLatch, int id) {
        this.startLatch = startLatch;
        this.threadId = id;
        this.endLatch = endLatch;

    }

    @Override
    public void run() {
        System.out.println("Thread " + threadId + " waiting");
        try {
            this.startLatch.await();
            System.out.println("Thread " + threadId + " is working");
            Thread.sleep(RANDOM.nextInt(5000));
            this.endLatch.countDown();
            System.out.println("Thread" + threadId + " is finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //TODO
    }
}
