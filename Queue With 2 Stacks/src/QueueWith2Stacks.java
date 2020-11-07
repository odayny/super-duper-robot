import java.util.Stack;

public class QueueWith2Stacks<T> implements Queue<T> {
    private final Stack<T> stack1 = new Stack<>();
    private final Stack<T> stack2 = new Stack<>();
    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public void enqueue(T item) {
        stack1.push(item);
    }

    @Override
    public T dequeue() {
        moveItemsIfNeeded();
        return stack2.pop();
    }

    private void moveItemsIfNeeded() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
