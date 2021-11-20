/** solved on an iPhone. Do not expect formatting **/

/**
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
**/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        /**
        o(lgn) by time and sorted array means binary search
        o(1) by space means no recursion
        so
        array will be odd size and until desire value will follow next pattern:
        value:     xxyyzz
        i (n+...): 123456
        
        after desire value that happens:
        value:     xyyzzq
        i (n+...): 123456
        
        in first case pair starts with odd index, in second: even
        
        lets check from the middle of array untill we reach exact one number (or corner case)
        **/
        
        int length = nums.length;
        //indexes: first, last, middle
        int first = 0;
        int last = length-1;
        
        while (first != last) {
            int mid = (first+last)/2;
            
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid+1]) {
                    first = mid;
                }
                else if (nums[mid]==nums[mid-1]){
                    last = mid;
                }
                else return nums[mid];
            } else {
                if (nums[mid] == nums[mid+1]) {
                    last = mid -1;
                } else if (nums[mid] == nums[mid-1]) {
                    first = mid+1;
                }
                else return nums[mid];
            }
        }
            
            /**
            
            // another corner case: 3 elements window. time for final decision
            if(mid-1 == first && mid+1 == last){
                if (nums[mid]==nums[first]) return nums[last];
else return nums[first];
            }
            
            // so lest see what is aroud
            if (nums[mid] == nums[mid+1]) {
                if (mid%2==0)
// its somewhere on the right
                first = mid+2;
                else
                  // it's somewhere on the left
             last = mid -1;  
} else if (nums[mid]==nums[mid-1]) {
                if (mid%2 == 1)
                // it's somewhere on the left
             last = mid -2;   
                else
                    // its somewhere on the right
                first = mid+1;
} else{
// another corner case: we hit right in a sweet spot
            return nums[mid];}
        }
**/
        return nums[first];
        
    }
}
