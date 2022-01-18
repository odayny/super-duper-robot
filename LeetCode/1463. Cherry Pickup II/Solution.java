/*
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 

Example 1:


Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:


Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
 

Constraints:

rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100
*/

class Solution {
    /*
    r1
    3  0  0
    5  8  0
    8  13 13
    15 14 14
    
    r2
    0  0  1
    0  6  2
    7  11 11
    13 12 12
    
    r1 & r2
    3  0  0  | 0  0  1    r1 0 r2 3
    ^                *
    5  8  0  | 0  6  2    r1 0 r2 1
    ^             *
    6  10 0  | 7  11 11   r1 1 r2 2
       ^.            *
    12 11 11 | 0  12 12
    ^                *
    
    

    12 + 12 = 24
    12 + 12 = 24
    12 + 0 = 12
    11 + 12 = 23
    11 + 0 = 11
    10 + 7 = 17
    
    
    
    */
    
    //let's move robots simultaniously
//     public int cherryPickup(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
        
//         // robot positions in ith row
//         int r1start = 0;
//         int r2start = cols - 1;

//         int[][][] dp = new int[rows][cols][cols];
        
//         //initialization of dp
//         dp[0][r1start][r2start] = grid[0][r1start] + grid[0][r2start];
//         int max = 0;
//         for (int rowIdx = 1; rowIdx < rows; rowIdx++) {
//             for (int r1pos = r1start; (r1pos <= r1start + rowIdx) || (r1pos < cols); r1pos++) {
//                 for (int r2pos = r2start; (r2pos >= r2start - rowIdx) || (r2pos >= 0); r2pos--) {
//                     int r1maxPrev = 0;
//                     for (int r1prev = r1pos - 1; r1prev <= r1pos + 1; r1prev++) {
//                         if (r1prev >= 0 && r1prev < cols) {
//                             r1maxPrev = Math.max(r1maxPrev, dp[rowIdx][r1prev][r2pos]);
//                         }
//                     }
//                     int r2maxPrev = 0;
//                     for (int r2prev = r2pos - 1; r2prev <= r2pos + 1; r2prev++) {
//                         if (r2prev >= 0 && r2prev < cols) {
//                             r2maxPrev = Math.max(r2maxPrev, dp[rowIdx][r1pos][r2prev]);
//                         }
//                     }
//                     int r1CurrVal = grid[rowIdx][r1pos];  
//                     if (r1pos != r2pos) {
//                         int r2CurrVal = grid[rowIdx][r2pos];
//                         dp[rowIdx][r1pos][r2pos] = r1CurrVal + r2CurrVal + r1maxPrev + r2maxPrev;
//                     } else {
//                         dp[rowIdx][r1pos][r2pos] = r1CurrVal + r1maxPrev + r2maxPrev;
//                     }
//                     max = Math.max(max,dp[rowIdx][r1pos][r2pos]);
//                 }    
//             }
//         }
//         return max;
//     }
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[i].length; j++)
                for (int k = 0; k < dp[i][j].length; k++)
                    dp[i][j][k] = -1;
        return dp(0, 0, cols - 1, grid, dp);
    }
    private int dp(int row, int r1col, int r2col, int[][] grid, int[][][] dp) {
        if (r1col < 0 || r2col < 0 || r1col >= grid[0].length || r2col>= grid[0].length) {
            return 0;
        }
        if (dp[row][r1col][r2col] != -1) {
            return dp[row][r1col][r2col];
        }
        int result = grid[row][r1col];
        if (r1col != r2col) result+= grid[row][r2col];
        if (row < grid.length -1) {
            int prevMax = 0;
            for (int r1prevCol = r1col - 1; r1prevCol <= r1col+1; r1prevCol++) 
                for (int r2prevCol = r2col - 1; r2prevCol <= r2col+1; r2prevCol++) 
                    prevMax = Math.max(prevMax, dp(row+1, r1prevCol, r2prevCol, grid, dp));
            result +=prevMax;
        }
        dp[row][r1col][r2col] = result;
        return result;
    }

    
}
