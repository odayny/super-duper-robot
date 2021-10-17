/*
Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

Example

For n = 152, the output should be
deleteDigit(n) = 52;
For n = 1001, the output should be
deleteDigit(n) = 101.
Input/Output

[execution time limit] 3 seconds (java)

[input] integer n

Guaranteed constraints:
10 ≤ n ≤ 106.

[output] integer
*/

int deleteDigit(int n) {
    int right = 0;
    int left = n / 10;
    int counter = 0;
    int max = left;
    int buffer = n % 10;
    while (left != 0) {
        right += buffer;
        counter++;
        buffer = left % (int) Math.pow(10, counter) * 10;
        left = (left / (int) Math.pow(10, counter)) * (int) Math.pow(10, counter);
        int curr = left + right;
        if (curr > max) {
            max = curr;
        }
    }
    return max;    
}
