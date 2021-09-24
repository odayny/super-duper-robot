class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] pointers = new int[n];
        int kthMinVal = 0;
        int count = 0;
        int firstLine = 0;
        while (count != k) {
            for (int i = firstLine; i < n; i++) {
                if (pointers[i] < n) {
                    firstLine = i;
                    break;
                }
            }
            
            int minVal = matrix[firstLine][pointers[firstLine]];
            int lineFound = firstLine;
            for (int i = firstLine + 1; i < n; i++) {
                if (pointers[i] == n) {
                    continue;
                }
                if (matrix[i][pointers[i]] < minVal) {
                    minVal = matrix[i][pointers[i]];
                    lineFound = i;
                    break;
                }
            }
            
            pointers[lineFound]++;
            count++;
            kthMinVal = minVal;
         
            
        }
        return kthMinVal;
    }
}

