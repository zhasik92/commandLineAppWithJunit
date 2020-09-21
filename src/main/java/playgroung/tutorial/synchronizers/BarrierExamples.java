package playgroung.tutorial.synchronizers;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class BarrierExamples {
    private static final int nTasks = 22;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier barrier = new CyclicBarrier(nTasks + 1);
        for (int i = 0; i < nTasks; i++) {
            new Thread(new Task(barrier, i)).start();
        }
        Thread.sleep(2000);
        System.out.println("awaiting barrier");
        barrier.await();
        System.out.println("awaiting again barrier");
        barrier.await();
        System.out.println("work is done");
    }

    private static class Task implements Runnable{
        private static final Random RANDOM = new Random();
        private final CyclicBarrier barrier;
        private final int threadId;
        public Task(CyclicBarrier barrier, int threadId) {
            this.barrier = barrier;
            this.threadId =   threadId;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadId + " waiting");
            try {
                this.barrier.await();
                System.out.println("Thread " + threadId + " is working");
                Thread.sleep(RANDOM.nextInt(5000));
                System.out.println("Thread" + threadId + " is finished");
                this.barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
            //TODO
        }
    }
}
