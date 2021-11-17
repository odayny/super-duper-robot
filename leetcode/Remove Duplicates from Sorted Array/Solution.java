class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pointer - 1] != nums[i]) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}
