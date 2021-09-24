/*
You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

Example

For inputArray = [1, 1, 1], the output should be
arrayChange(inputArray) = 3.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer inputArray

Guaranteed constraints:
3 ≤ inputArray.length ≤ 105,
-105 ≤ inputArray[i] ≤ 105.

[output] integer

The minimal number of moves needed to obtain a strictly increasing sequence from inputArray.
It's guaranteed that for the given test cases the answer always fits signed 32-bit integer type.
*/
int arrayChange(int[] inputArray) {
    int result = 0;
    for (int i = 1; i < inputArray.length; i++) {
        if (inputArray[i] <= inputArray[i-1]) {
            result += inputArray[i-1] + 1 - inputArray[i];
            inputArray[i] = inputArray[i-1] + 1;
        }
    }
    return result;
}
