"""
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1
"""

"""
1. Build a trie for all 31bit numbers.
2. Run trough all nubmers again by looking in a trie for max XOR (try to find an opposite bit each time)
3. Return max
"""
class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        # trie
        root = {} 
        # populate trie
        for n in nums :
            curr = root
            for pos in range(31, -1, -1) :
                bit = (n >> pos) & 1
                if bit in curr :
                    curr = curr[bit]
                else :
                    curr[bit] = {}
                    curr = curr[bit]
        
        #search
        maxval = 0
        for n in nums :
            curr = root
            currval = 0
            for pos in range(31, -1, -1) :
                currval = currval << 1
                bit = (n >> pos) & 1
                targ = bit ^ 1
                if targ in curr :
                    curr = curr[targ]
                    currval += 1
                else :
                    curr = curr[bit]
            maxval = max(maxval, currval)
        
        return maxval
