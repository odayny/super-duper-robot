import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private int openSites = 0;
    private int topMetanode;
    private int bottomMetanode;
    private boolean[][] grid;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        validateInput(n);
        this.n = n;
        generateGrid();
        generateGraph();
    }

    private void validateInput(int... input) {
        if (input.length == 1 && input[0] <= 0) {
            throw new IllegalArgumentException(String.format("Value %d must be > 0", input[0]));
        }
        if (input.length == 2 && (input[0] <= 0 || input[0] > n || input[1] <= 0 || input[1] > n)) {
            throw new IllegalArgumentException(
                    String.format("All values must be > 0 and <= %d. Your input: %d %d", n,
                                  input[0], input[1]));
        }
    }

    private void generateGrid() {
        grid = new boolean[n][n];
    }

    private void generateGraph() {
        uf = new WeightedQuickUnionUF(n * n + 2);
        topMetanode = n * n;
        bottomMetanode = n * n + 1;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(StdIn.readInt());
        while (!percolation.percolates()) {
            percolation.open(StdIn.readInt(), StdIn.readInt());
        }
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(topMetanode) == uf.find(bottomMetanode);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateInput(row, col);
        row--;
        col--;
        if (grid[row][col]) {
            return;
        }
        openSites++;
        grid[row][col] = true;

        // top and bottom special cases
        if (row == 0) {
            uf.union(topMetanode, getUFNode(row, col));
        }
        if (row == n - 1) {
            uf.union(bottomMetanode, getUFNode(row, col));
        }

        // connect neighbour nodes if needed
        safeUnion(row - 1, col, row, col);
        safeUnion(row + 1, col, row, col);
        safeUnion(row, col + 1, row, col);
        safeUnion(row, col - 1, row, col);
    }

    private int getUFNode(int row, int col) {
        return row * n + col;
    }

    private void safeUnion(int row, int col, int valiodRow, int validCol) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return;
        }
        if (grid[row][col]) {
            uf.union(getUFNode(row, col), getUFNode(valiodRow, validCol));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateInput(row, col);
        row--;
        col--;
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateInput(row, col);
        row--;
        col--;
        return grid[row][col] && uf.find(topMetanode) == uf.find(getUFNode(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

}
