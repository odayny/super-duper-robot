/*
Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order, starting from top-left and in clockwise direction.

Example

For n = 3, the output should be

spiralNumbers(n) = [[1, 2, 3],
                    [8, 9, 4],
                    [7, 6, 5]]
Input/Output

[execution time limit] 3 seconds (java)

[input] integer n

Matrix size, a positive integer.

Guaranteed constraints:
3 ≤ n ≤ 100.

[output] array.array.integer
*/

int[][] spiralNumbers(int n) {
    int i = 0, j = 0;
    int limT = 0, limL = -1, limB = n, limR = n-1;
    int d = 1;
    int[][] result = new int[n][n];
    while (d <= n * n) {
        //assignment
        result[i][j] = d++;
        
        //moving to next cell
        if (i == limT && j < limR) {
            j++;
        } else if (j == limR && i < limB) {
            i++;
        } else if (i == limB && j > limL) {
            j--;
        } else if (j == limL && i > limT) {
            i--;
        }
        
        // limits 
        if (i == limT && j == limL) {
            limR--;
        } else if (i == limT && j == limR) {
            limB--;
        } else if (i == limB && j == limR) {
            limL++;
        } else if (i == limB && j == limL) {
            limT++;
        }
     }
     return result;
}
