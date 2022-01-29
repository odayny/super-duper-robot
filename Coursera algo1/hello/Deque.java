import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;

    // unit testing (required)
    public static void main(String[] args) {
        // gonna test it on prod
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        nullCheck(item);
        size++;

        // initial
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        }
        else {
            first = new Node<>(first, item);
            if (last == null) {
                last = first;
            }
        }
    }

    private void nullCheck(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null && last == null;
    }

    // add the item to the back
    public void addLast(Item item) {
        nullCheck(item);
        size++;

        // initial
        if (isEmpty()) {
            first = new Node<>(item);
            last = first;
        }
        else {
            last = new Node<>(item, last);
            if (first == null) {
                first = last;
            }
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        emptyCheck();

        size--;

        Item res = first.item;
        first = first.prev;
        if (first == null) {
            last = null;
        }
        else {
            first.next = null;
        }
        return res;
    }

    private void emptyCheck() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        emptyCheck();

        size--;

        Item res = last.item;
        last = last.next;
        if (last == null) {
            first = null;
        }
        else {
            last.prev = null;
        }
        return res;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator(this);
    }

    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item) {
            this.item = item;
        }

        public Node(Node<T> first, T item) {
            this.item = item;
            first.next = this;
            this.prev = first;
        }

        public Node(T item, Node<T> last) {
            this.item = item;
            last.prev = this;
            this.next = last;
        }
    }

    private class DequeIterator implements Iterator<Item> {
        Deque<Item> dec;
        Node<Item> pointer;

        public DequeIterator(Deque<Item> dec) {
            this.dec = dec;
            pointer = dec.first;
        }

        public boolean hasNext() {
            return pointer != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Deque is empty");
            }
            Item res = pointer.item;
            pointer = pointer.prev;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
}
