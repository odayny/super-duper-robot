public interface  Queue<T> {
    boolean isEmpty();
    void enqueue(T item);
    T dequeue();
}
