/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
 */
class Solution {
    public void moveZeroes_(int[] nums) {
        // fuck 'move' work. let's just shift everything
        int source = 0;
        int target = 0;
        while (target < nums.length) {
            if (source >= nums.length) {
                nums[target++] = 0;
            } else if (nums[source] != 0) {
                nums[target++] = nums[source++];    
            } else {
                source++;
            }
        }
    }
    public void moveZeroes(int[] nums) {
        mvZ(nums, nums.length-1);
    }
    private int mvZ(int[] nums, int end) {
        if (0 == end) {
            return nums[0] == 0 ? -1 : 0;
        }
        int target = mvZ(nums, end - 1);
        if (nums[end] != 0 && (end - target > 1)) {
            nums[++target] = nums[end];
            nums[end] = 0;
            return target;
        }
        return nums[target + 1] == 0 ? target : target+1;
    }
}
