import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first;
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
    public void enqueue(Item item) {
        nullCheck(item);
        size++;

        // initial
        if (isEmpty()) {
            first = new Node<>(item);
        }
        else {
            first = new Node<>(first, item);
        }
    }

    private void nullCheck(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }


    // remove and return the item from the back
    public Item dequeue() {
        emptyCheck();

        size--;
        Node<Item> champ = getRandomNode(first);
        Item res = champ.item;
        cleanup(champ);
        return res;
    }

    private void emptyCheck() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
    }

    private Node<Item> getRandomNode(Node<Item> root) {
        Node<Item> champ = null;
        Node<Item> current = root;
        int counter = 1;
        while (current != null) {
            if (1 / ((double) StdRandom.uniform(counter) + 1) == 1) {
                champ = current;
            }
            current = current.prev;
            counter++;
        }
        return champ;
    }

    private void cleanup(Node<Item> champ) {
        if (champ == first) {
            first = champ.prev;
            if (first != null) {
                first.next = null;
            }
        }
        else {
            if (champ.prev != null) {
                champ.prev.next = champ.next;
            }
            champ.next.prev = champ.prev;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new RandomQueueIterator(this);
    }

    // remove and return the item from the front
    public Item sample() {
        emptyCheck();
        return getRandomNode(first).item;
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

    }

    private class RandomQueueIterator implements Iterator<Item> {
        Node<Item> pointer = null;

        public RandomQueueIterator(RandomizedQueue<Item> rq) {
            Node<Item> curr = rq.first;
            while (curr != null) {
                if (pointer == null) {
                    pointer = new Node<>(curr.item);
                }
                else {
                    pointer = new Node<>(pointer, curr.item);
                }
                curr = curr.prev;
            }
        }

        public boolean hasNext() {
            return pointer != null;
        }

        public Item next() {
            if (pointer == null) {
                throw new NoSuchElementException("RandomQueue is empty");
            }
            Node<Item> randomNode = getRandomNode(pointer);
            Item res = randomNode.item;
            cleanup(randomNode);
            return res;
        }

        private void cleanup(Node<Item> champ) {
            if (champ == pointer) {
                pointer = champ.prev;
                if (pointer != null) {
                    pointer.next = null;
                }
            }
            else {
                if (champ.prev != null) {
                    champ.prev.next = champ.next;
                }
                champ.next.prev = champ.prev;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
}

