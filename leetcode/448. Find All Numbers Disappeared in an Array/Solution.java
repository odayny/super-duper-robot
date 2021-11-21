/**
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
**/

/**
so idea here is to modify original array and use pointers. what if we can modify value in nums[nums[i]] somehow non-destructive (because we may want to use it again)
and use pointers of non-modified cells as a result
**/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pointer = Math.abs(nums[i]) - 1;
            if (nums[pointer] > 0) {
                nums[pointer] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}