class Solution {
    final int modulo = (int) Math.pow(10,9)+7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long maxSum = 0;
        long maxCurrent = 0;
        long prevMaxSum = 0;
        long increaseRate = 0;
        for (int j = 0; j < k; j++) {
            // implemented Kadane's algorithm
            // (will go through array and find maximum subarray)
            for (int i = 0; i < arr.length; i++) {
                int value = arr[i];
                maxCurrent += value;
                if (maxCurrent < 0) {
                    maxCurrent = 0;
                }
                if (maxCurrent > maxSum) {
                    maxSum = maxCurrent;
                }
            }
            // but array is repeated k times
            // possible scenarios:
            //  1. maximum subarray sum will remain the same
            //  2. maximum subarray sum will increase with constant rate every kth repeat
                   
            // so let's define increase rate
            increaseRate = maxSum - prevMaxSum;
            prevMaxSum = maxSum;
            
            // after 3rd iteration nothing gonna change dramatically so let's calculate result
            if (j > 1) {
                return (int)((maxSum + increaseRate * (k-j-1))%modulo);
            }
        }
        // 3. if (k < 3) - regular Kadane's algorithm will be just fine. we cannot rely on increase rate yet
        return (int) (maxSum % modulo);
    }
}
// 1 -2 1 1 -2 1
