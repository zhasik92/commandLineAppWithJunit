package playgroung.list;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class BrokenBlockingQueueTest {
    private static final int INSERTS_PER_THREAD = 20000;
    private static final int TASKS_COUNT = 1;
    private static final int GAP = 10;

    @Test(timeout = 2 * 1000)
    public void put() {
    }

  /*  @Test(timeout = 2 * 1000)
    public void take() {
        BrokenBlockingQueue<String> queue = new BrokenBlockingQueue<>();
        queue.put("banana");
        queue.put("orange");
        queue.take();
        String take = queue.take();
        assertEquals("banana", take);
        assertEquals(0, queue.getSize());
        //assertNull(queue.take());
    }

    @Test
    public void concurrentInsertsConsistencyTest() throws InterruptedException, ExecutionException {
        BrokenBlockingQueue<Long> queue = new BrokenBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(TASKS_COUNT);
        CountDownLatch startLatch = new CountDownLatch(TASKS_COUNT);
        CountDownLatch endLatch = new CountDownLatch(TASKS_COUNT);
        for (int i = 0; i < TASKS_COUNT; i++) {
            executorService.execute(new Task(queue, i, startLatch, endLatch));
        }
        endLatch.await();
        assertEquals(TASKS_COUNT * INSERTS_PER_THREAD, queue.getSize());
        CountDownLatch takeLatch = new CountDownLatch(2);

        Future<?> submit = executorService.submit(() -> {
            Long take = null;
            for (int i = 0; i < TASKS_COUNT * INSERTS_PER_THREAD; i++) {
                take = queue.take();
            }
            System.out.println("take=" + take);
            takeLatch.countDown();
            return take;
        });
        takeLatch.countDown();
        takeLatch.await();
        assertTrue(submit.isDone());
        assertNotNull(submit.get());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void concurrentPutTakeConsistencyTest() throws InterruptedException {
        BrokenBlockingQueue<Long> queue = new BrokenBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(TASKS_COUNT*2);
        CountDownLatch startLatch = new CountDownLatch(TASKS_COUNT * 2);
        CountDownLatch endLatch = new CountDownLatch(TASKS_COUNT * 2+1);
        for (int i = 0; i < TASKS_COUNT; i++) {
            executorService.execute(new Task(queue, i, startLatch, endLatch));
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Taking Thread " + taskId + " started");

                startLatch.countDown();
                try {
                    System.out.println("Taking Thread " + taskId + " waiting at latch, latch = " + startLatch.getCount());
                    startLatch.await();
                    System.out.println(" Taking Thread " + taskId + " passed latch");
                    for (int j = 0; j < (INSERTS_PER_THREAD - GAP); j++) {
                        queue.take();
                    }
                    endLatch.countDown();
                    System.out.println("Taking Thread " + taskId + " finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        endLatch.countDown();
        endLatch.await();
        assertEquals(TASKS_COUNT * (GAP), queue.getSize());
        assertEquals(TASKS_COUNT * GAP, queue.getSize());
    }

    private static class Task implements Runnable {
        private final BrokenBlockingQueue<Long> queue;
        private final ThreadLocalRandom current = ThreadLocalRandom.current();
        private final int taskId;
        private final CountDownLatch startLatch;
        private final CountDownLatch endLatch;

        public Task(BrokenBlockingQueue<Long> queue,
                    int taskId,
                    CountDownLatch startLatch,
                    CountDownLatch endLatch) {
            this.queue = queue;
            this.taskId = taskId;
            this.startLatch = startLatch;
            this.endLatch = endLatch;
        }

        @Override
        public void run() {
            System.out.println("Thread " + taskId + " started");
            startLatch.countDown();
            try {
                System.out.println("Thread " + taskId + " waiting at latch, latch = " + startLatch.getCount());
                startLatch.await();
                System.out.println("Thread " + taskId + " passed latch");
                for (int i = 0; i < INSERTS_PER_THREAD; i++) {
                    long value = current.nextLong(1, 5000);
                    queue.put(value);
                    //  System.out.println("inserting value " + value);
                }
                System.out.println("Thread " + taskId + " finished");
                endLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}