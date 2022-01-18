/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100
/*
class Solution {
    int[][] dp;
    int[] arr;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr =  new int[n+2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = 1;
        arr[n+1] = 1;
        dp = new int[n+2][n+2];

        return recursion(1, n);
    }
    private int recursion(int left, int right) {
        if (left > right) return 0;
        if (dp[left][right] > 0) return dp[left][right];
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = arr[i] * arr[left-1] * arr[right+1];
            res += recursion(left, i - 1);
            res += recursion(i + 1, right);
            dp[left][right] = Math.max(dp[left][right], res);
        }
        return dp[left][right];
    }
}

//https://www.youtube.com/watch?v=VFskby7lUbw&t=3s
