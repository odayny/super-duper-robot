public class QueueWith2StacksTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new QueueWith2Stacks<>();
        queue.enqueue(1);
        System.out.println("1? " + queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("2? " + queue.dequeue());
        queue.enqueue(4);
        System.out.println("3? " + queue.dequeue());
        System.out.println("4? " + queue.dequeue());
        System.out.println("fail? " + queue.dequeue());
    }
}
