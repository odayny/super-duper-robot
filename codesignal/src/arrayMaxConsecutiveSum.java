/*
Given array of integers, find the maximal possible sum of some of its k consecutive elements.

Example

For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
arrayMaxConsecutiveSum(inputArray, k) = 8.
All possible sums of 2 consecutive elements are:

2 + 3 = 5;
3 + 5 = 8;
5 + 1 = 6;
1 + 6 = 7.
Thus, the answer is 8.
Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer inputArray

Array of positive integers.

Guaranteed constraints:
3 ≤ inputArray.length ≤ 105,
1 ≤ inputArray[i] ≤ 1000.

[input] integer k

An integer (not greater than the length of inputArray).

Guaranteed constraints:
1 ≤ k ≤ inputArray.length.

[output] integer

The maximal possible sum.
*/
int arrayMaxConsecutiveSum(int[] a, int k) {
    int max = 0;
    // count first sum
    for (int i = 0; i < k; i++) {
        max += a[i];
    }
    int begin = 0;
    int end = k;
    int sum = max;
    while (end < a.length) {
        sum -= a[begin++];
        sum += a[end++];
        if (max < sum) {
            max = sum;
        }
    }
    return max;
}
