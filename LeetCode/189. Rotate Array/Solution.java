/**
reversing is better
**/
/**
Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
**/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int replacements = 0;
        int offset = 0;
        int iter = 1;
        int buffer = nums[0];
        while (replacements < n) {
            int targetPointer = (offset + iter * k) % n;
            int temp = nums[targetPointer];
            nums[targetPointer] = buffer;
            buffer = temp;
            iter++;
            replacements++;
            if (targetPointer == offset) {
                offset++;
                iter = 1;
                int sourcePointer = (offset + (iter - 1) * k) % n;
                buffer = nums[sourcePointer];
            } 
        }
    }
}
