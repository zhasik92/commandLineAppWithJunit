package playgroung.list;

public interface Queue<T> {
    void put(T value);

    T take();
}
