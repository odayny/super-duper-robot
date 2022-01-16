import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first = null;
    private Node<Item> last = null;
    private int size = 0;
    private Random random;
    public RandomizedQueue() {
    }

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        rq.enqueue("test1");
        rq.enqueue("test2");
        rq.enqueue("test3");
        rq.enqueue("test4");
        rq.enqueue("test5");
        rq.enqueue("test6");
        rq.enqueue("test7");
        rq.enqueue("test8");
        System.out.println(rq.sample());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.sample());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.sample());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
        System.out.println(rq.dequeue());
        System.out.println(rq.isEmpty());
        System.out.println(rq.size());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        checkForNull(item);
        Node<Item> newNode = new Node<>(item);
        if (last != null) {
            last.next = newNode;
            last = newNode;
        } else {
            last = newNode;
            first = newNode;
        }
        size++;
    }

    public Item dequeue() {
        checkForEmpty();
        initRandom();
        int pos = random.nextInt(size);
        Node<Item> prevNode = null;
        Node<Item> node = first;
        while (pos != 0) {
            prevNode = node;
            node = node.next;
            pos--;
        }
        if (prevNode != null) {
            prevNode.next = node.next;
        } else {
            first = node.next;
        }
        if (last == node) {
            last = prevNode;
        }
        Item item = node.item;
        size--;
        return item;
    }

    public Item sample() {
        checkForEmpty();
        initRandom();
        int pos = random.nextInt(size);
        Node<Item> node = first;
        while (pos != 0) {
            node = node.next;
            pos--;
        }
        return node.item;
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
                return dequeue();
            }
        };
    }

    private void checkForNull(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
    }

    private void checkForEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("RandomizedQueue is empty");
        }
    }
    private static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }
    private void initRandom() {
        if (random == null) {
            random = new Random();
        }
    }
}
