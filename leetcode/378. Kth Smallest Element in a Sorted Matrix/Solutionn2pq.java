class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
            }
        }
        for (int i = 1; i< k; i++) pq.poll();
        return pq.peek();
    }
}

//     1, 6, 9
//     4,11,13
//     8,13,15
