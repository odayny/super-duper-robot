class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {nums[0]: 0}
        i = 1
        
        while i < len(nums) :
            desired = target - nums[i]
            if desired in dict :
                return {dict[desired], i}
            dict[nums[i]] = i
            i += 1
        
