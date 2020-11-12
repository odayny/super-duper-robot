import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;

    public Deque() {
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("test1");
        System.out.println(deque.isEmpty());
        System.out.println(deque.size);
        System.out.println(deque.removeFirst());
        System.out.println(deque.isEmpty());
        System.out.println(deque.size);
        deque.addFirst("test2");
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        deque.addFirst("test3");
        deque.addFirst("test4");
        deque.addLast("test5");
        deque.addFirst("test6");
        deque.addFirst("test7");
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.size());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        checkForNull(item);
        Node<Item> newNode = new Node<>(item);
        if (first != null) {
            first.previous = newNode;
        } else {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    private void checkForNull(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
    }

    public void addLast(Item item) {
        checkForNull(item);
        Node<Item> newNode = new Node<>(item);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        newNode.previous = last;
        last = newNode;
        size++;
    }

    public Item removeFirst() {
        checkForEmpty();
        Item item = first.item;
        if (first.next != null) {
            first.next.previous = null;
            first = first.next;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    private void checkForEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
    }

    public Item removeLast() {
        checkForEmpty();
        Item item = last.item;
        if (last.previous != null) {
            last.previous.next = null;
            last = last.previous;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Item next() {
                return removeFirst();
            }
        };
    }

    private static class Node<Item> {
        Item item;
        Node<Item> previous;
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }
}
