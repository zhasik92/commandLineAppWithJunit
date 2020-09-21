package playgroung.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnsafeQueueTest {

    @Test
    public void put() {
    }

    @Test
    public void take() {
    }

    @Test
    public void testQueue() {
        UnsafeQueue<String> unsafeQueue = new UnsafeQueue<>();
        unsafeQueue.put("apples");
        unsafeQueue.put("bananas");
        unsafeQueue.put("oranges");
        assertEquals("oranges", unsafeQueue.take());
        assertEquals("bananas", unsafeQueue.take());
        unsafeQueue.put("kiwi");
        assertEquals("kiwi", unsafeQueue.take());
        assertEquals("apples", unsafeQueue.take());
        assertNull( unsafeQueue.take());
        assertNull( unsafeQueue.take());
        assertNull( unsafeQueue.take());

    }
}