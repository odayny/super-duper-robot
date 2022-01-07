/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

class Solution {
    //n^2 time. 1 space
    // public int[] twoSum(int[] nums, int target) {
    //     for (int i =0; i < nums.length-1; i++) {
    //         for (int j = i+1; j < nums.length; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return new int[]{-1, -1};
    // }
    //n time. n space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        int idx = 1;
        while (true) {
            int second = target - nums[idx];
            if (map.containsKey(second)) {
                return new int[]{map.get(second), idx};
            } else {
                map.put(nums[idx], idx);
            }
            idx++;
        }
    }
    //with sorting
    // public int[] twoSum(int[] nums, int target) {
    //     int[] copy = Arrays.copyOf(nums, nums.length);
    //     Arrays.sort(nums);
    //     int start = 0;
    //     int end = nums.length - 1;
    //     int sum = nums[start] + nums[end];
    //     while (sum != target) {
    //         if (sum > target) {
    //             end--;
    //         } else {
    //             start++;
    //         }
    //         sum = nums[start] + nums[end];  
    //     }
    //     int[] res = new int[2];
    //     int resIdx = 0;
    //     for (int i = 0; i < copy.length; i++) {
    //         if (nums[start] == copy[i] || nums[end] == copy[i]) {
    //             res[resIdx++] = i;
    //             if (nums[start] == copy[i]) {
    //                 start = end;
    //             } else {
    //                 end = start;
    //             }
    //         }
    //         if (resIdx > 1) {
    //             break;
    //         }
    //     }
    //     return res;
    // }

}
