import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        int count = Integer.parseInt(args[0]);
        while (count != 0) {
            StdOut.println(rq.dequeue());
            count--;
        }
    }
}
