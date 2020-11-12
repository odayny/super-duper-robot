import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf; // union find logic here
    private final int n;
    private final int virtualTopPoint;
    private final int virtualBottomPoint;
    private final boolean[] openClose; // array for open-close info
    private int openCount = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be more than 0");
        }
        uf = new WeightedQuickUnionUF(n * n + 2); // last 2 are virtual points which will be connected to 0-th and
        // n-th rows
        openClose = new boolean[n * n];
        this.n = n;
        virtualTopPoint = n * n;
        virtualBottomPoint = n * n + 1;
    }

    // test client (optional)
    public static void main(String[] args) {
        StdOut.println("Percolation test began");
        int n = StdRandom.uniform(20) + 1;
        StdOut.println("n = " + n);
        Percolation percolation = new Percolation(n);
        while (!percolation.percolates()) {
            int row = StdRandom.uniform(n) + 1;
            int col = StdRandom.uniform(n) + 1;
            percolation.open(row, col);

        }
        StdOut.println("Percolates!");
        StdOut.println(percolation.numberOfOpenSites() + " sites were opened");
        StdOut.println("Site vacancy " + ((double) percolation.numberOfOpenSites() / ((double) n * n)));
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int internalRow = getInternal(row);
        int internalCol = getInternal(col);
        validate(internalRow, internalCol);
        int pos = getPosition(internalRow, internalCol);
        if (!openClose[getPosition(internalRow, internalCol)]) {
            saveOpenState(pos);
            connectToVirtualPoints(internalRow, pos);
            unionWithNeighborsIfOpen(row, col, pos);
        }
    }

    private int getInternal(int coord) {
        return coord - 1;
    }

    private void unionWithNeighborsIfOpen(int row, int col, int pos) {
        if (getInternal(row) >= 1 && isOpen(getInternal(row), col)) {
            uf.union(pos, getPosition(getInternal(row - 1), getInternal(col)));
        }
        if (row + 1 <= n && isOpen(row + 1, col)) {
            uf.union(pos, getPosition(getInternal(row + 1), getInternal(col)));
        }
        if (getInternal(col) >= 1 && isOpen(row, getInternal(col))) {
            uf.union(pos, getPosition(getInternal(row), getInternal(col - 1)));
        }
        if (col + 1 <= n && isOpen(row, col + 1)) {
            uf.union(pos, getPosition(getInternal(row), getInternal(col + 1)));
        }
    }

    private void connectToVirtualPoints(int row, int pos) {
        if (row == 0) {
            uf.union(virtualTopPoint, pos);
        }
        if (row == getInternal(n)) {
            uf.union(virtualBottomPoint, pos);
        }
    }

    private void saveOpenState(int pos) {
        openClose[pos] = true;
        openCount++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int internalRow = getInternal(row);
        int internalCol = getInternal(col);
        validate(internalRow, internalCol);
        return openClose[getPosition(internalRow, internalCol)];
    }

    // converts coordinates to position in n*n array
    private int getPosition(int row, int col) {
        return row * n + col;
    }

    // this one will throw a exception if needed
    private void validate(int row, int col) {
        if (row < 0 || row > getInternal(n) || col < 0 || col > getInternal(n)) {
            throw new IllegalArgumentException("Bad coordinates " + row + " " + col);
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int internalRow = getInternal(row);
        int internalCol = getInternal(col);
        validate(internalRow, internalCol);
        if (!isOpen(row, col)) {
            return false;
        }
        return uf.find(virtualTopPoint) == uf.find(getPosition(internalRow, internalCol));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        if (openCount < n) { // no way it does
            return false;
        }
        return uf.find(virtualTopPoint) == uf.find(virtualBottomPoint);
    }
}
