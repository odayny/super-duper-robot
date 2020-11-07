import java.util.concurrent.ThreadLocalRandom;

public class ResizingArrayQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ResizingArrayQueue<>();
        int value = 1;
        for (int ii = 0; ii < ThreadLocalRandom.current().nextInt(1, 100 + 1); ii++){
            queue.enqueue(value++);
        }
        for (int ii = 0; ii < ThreadLocalRandom.current().nextInt(1, value  + 1); ii++){
            if (Math.random() < 0.5) {
                for (int jj = 0; jj < ThreadLocalRandom.current().nextInt(1, value + 1); jj++){
                    queue.enqueue(value++);
                }
            } else {
                for (int jj = 0; jj < ThreadLocalRandom.current().nextInt(1, value); jj++){
                    System.out.println(queue.dequeue());
                }
            }
        }
        System.out.println("final " +value);
    }
    public static void oldmain(String[] args) {
        int item = 1;
        Queue<Integer> queue = new ResizingArrayQueue<>();
        queue.enqueue(item++);
        System.out.println("1? " + queue.dequeue());
        queue.enqueue(item++);
        queue.enqueue(item++);
        System.out.println("2? " + queue.dequeue());
        queue.enqueue(item++);
        System.out.println("3? " + queue.dequeue());
        System.out.println("4? " + queue.dequeue());
        for (int ii = 0; ii < 60; ii++) {
            queue.enqueue(item++);
        }
        for (int ii = 0; ii < 50; ii++) {
            System.out.println(queue.dequeue());
        }
        for (int ii = 0; ii < 60; ii++) {
            queue.enqueue(item++);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        System.out.println("fail? " + queue.dequeue());
    }

}
