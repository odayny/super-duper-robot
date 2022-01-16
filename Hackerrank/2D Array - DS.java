// https://www.hackerrank.com/challenges/2d-array/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int posMin = 1;
        int posMax = 5;
        int result = Integer.MIN_VALUE;
        for (int i = posMin; i < posMax; i++) {
            for (int j = posMin; j < posMax; j++) {
                int sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
                        + arr[i][j]
                        + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                if (result < sum) {
                    result = sum;
                }
            }
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
