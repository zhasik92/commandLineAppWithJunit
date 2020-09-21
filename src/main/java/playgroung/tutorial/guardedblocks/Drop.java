package playgroung.tutorial.guardedblocks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    private final BlockingQueue<String> queue;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public Drop() {
        this.queue = new ArrayBlockingQueue(1);
    }

    public String take() throws InterruptedException {
        return this.queue.take();
    }

    public synchronized void put(String message) throws InterruptedException {
        this.queue.put(message);
    }
}
