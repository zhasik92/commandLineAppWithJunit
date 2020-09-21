package playgroung.list;

/**
 * Accept nulls
 * @param <T>
 */
public class UnsafeQueue<T> implements Queue<T> {
    private final Node<T> head = new Node<>();

    @Override
    public void put(T value) {
        Node<T> tNode = new Node<>(value);
        if (head.next == null) {
            head.next = tNode;
        } else {
            tNode.next = head.next;
            head.next = tNode;
        }
    }

    @Override
    public T take() {
        if (head.next == null) {
            return null;
        } else {
          T value = head.next.value;
          head.next = head.next.next;
          return value;
        }
    }

}
