"""
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
"""
class Solution:
    """
    idea: prep 2 arrays which stores a boundary of the ith element block to rhe left and to the right
    later: height with available width, which can be calculated from left and right array
    """
    
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        if n == 0 :
            return 0
        res = 0
        left = [-1]*n
        right = [n]*n
        
        for i in range(n) :
            prev = i - 1
            while prev >= 0 and heights[prev] >= heights[i] :
                prev = left[prev]
            left[i] = prev
        
        for i in range(n-1, -1, -1) :
            prev = i + 1
            while prev < n and heights[prev] >= heights[i] :
                prev = right[prev]
            right[i] = prev
        
        for i in range(n) :
            w = right[i] - left[i] - 1
            res = max(res, heights[i]*w)
        
        return res
            
        
    # time out
    def largestRectangleArea_rec(self, heights: List[int]) -> int:
        n = len(heights)
        
        if n == 0 :
            return 0
        if n == 1 :
            return heights[0]
        
        minPos = 0
        for i in range(1, n) :
            if heights[minPos] > heights[i] :
                minPos = i
        
        res = n*heights[minPos];
        
        return max(res, 
                   self.largestRectangleArea(heights[:minPos]), 
                   self.largestRectangleArea(heights[(minPos + 1):]))
