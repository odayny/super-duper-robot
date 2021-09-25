/*
In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.

Example

For

matrix = [[true, false, false],
          [false, true, false],
          [false, false, false]]
the output should be

minesweeper(matrix) = [[1, 2, 1],
                       [2, 1, 1],
                       [1, 1, 1]]
Check out the image below for better understanding:



Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.boolean matrix

A non-empty rectangular matrix consisting of boolean values - true if the corresponding cell contains a mine, false otherwise.

Guaranteed constraints:
2 ≤ matrix.length ≤ 100,
2 ≤ matrix[0].length ≤ 100.

[output] array.array.integer

Rectangular matrix of the same size as matrix each cell of which contains an integer equal to the number of mines in the neighboring cells. Two cells are called neighboring if they share at least one corner.
*/

int[][] minesweeper(boolean[][] matrix) {
    int[][] result = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j]) {
                if (i > 0) {
                    if (j > 0) {
                        result[i-1][j-1]++;
                    }
                    result[i-1][j]++;
                    if (j < matrix[i].length - 1) {
                        result[i-1][j+1]++;
                    }
                }
                if (j > 0) {
                    result[i][j-1]++;
                }
                if (j < matrix[i].length - 1) {
                    result[i][j+1]++;
                }
                if (i < matrix.length - 1) {
                    if (j > 0) {
                        result[i+1][j-1]++;
                    }
                    result[i+1][j]++;
                    if (j < matrix[i].length - 1) {
                        result[i+1][j+1]++;
                    }
                }
            }
        }
    }
    return result;
}
