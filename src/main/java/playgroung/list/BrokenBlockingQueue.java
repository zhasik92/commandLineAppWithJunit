package playgroung.list;

import java.util.concurrent.atomic.AtomicReference;

public class BrokenBlockingQueue<T> implements Queue<T> {
    private final AtomicReference<Node<T>> head = new AtomicReference<>();

    @Override
    public  void put(T value) {
        Node<T> node = new Node<>(value);
        while (true) {
            //   System.out.println("putting value " + value);
            if (head.get() == null) {
                if (head.compareAndSet(null, node))
                    return;
            } else {
                Node<T> currentHead = head.get();
                node.next.set(currentHead);
                if (currentHead != null) {
                    if (node.next.compareAndSet(currentHead, currentHead)) {
                        if (head.compareAndSet(currentHead, node)) return;
                    }
                }
            }
        }
    }

    @Override
    public  T take() {
        while (true) {
            Node<T> currentHead = head.get();
            if (currentHead != null) {
               // synchronized (this){
                    Node<T> next = currentHead.next.get();
                    if (head.compareAndSet(currentHead, next)) return currentHead.value;
             //   }
            }
        }

    }

    //NotThreadSafe
    public long getSize() {
        Node<T> current = head.get();
        long count = 0;
        while (current != null) {
            count++;
            current = current.next.get();
        }
        return count;
    }

    private static class Node<T> {
        final AtomicReference<Node<T>> next = new AtomicReference<>();
        final T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
