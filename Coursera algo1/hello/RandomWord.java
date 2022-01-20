import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champ = null;
        int i = 1;
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / (double) i)) {
                champ = str;
            }
            i++;
        }
        StdOut.print(champ);
    }
}
