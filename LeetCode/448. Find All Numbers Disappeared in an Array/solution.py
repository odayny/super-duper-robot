class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # lets use one point: input array contains only positine numbers
        # so lets malke value nums[n-1] negative if n is in an input
        
        n = len(nums)
        
        for i in range(n) :
            idx = abs(nums[i]) - 1
            nums[idx] = abs(nums[idx]) * (-1)
        
        res = []
        
        for i in range(n) :
            if nums[i] > 0 :
                res.append(i+1)
                
        return res
