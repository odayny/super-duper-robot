/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
**/
class Solution {
    public int uniquePaths(int m, int n) {
        //n is vert
        //m is hor
        //anyways...
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2 || n == 2) {
            if (m == 2) return n;
            if (n == 2) return m;
            return 2;
        }
                return uniquePaths(m - 1, n) + uniquePaths(m, n -1);
            
        
    }
}

/**
pathes
m=3, n=7
28 21 15 10  6  3  1
 7  6  5  4  3  2  1
 1  1  1  1  1  1  1

3x3
321
111
3

851
321
111

62 31 16 5 1
31 15 11 4 1
16 11 7  3 1
5. 4  3  2 1
1. 1  1  1 1

**/
