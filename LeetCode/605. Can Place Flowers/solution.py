"""
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
"""
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        """
        Count available flowerbeds and compare to n
        Shortcut: if available flowerbeds >= n at any moment - return true
        Available if no flowers in i-1 and i+1 positions
        If flowerbed available - skip next iteration to avoid error
        If flowerbed[i] == 1 - skip next iteration to save time
        """
        available = 0
        i = 0
        while i < len(flowerbed) :
            if flowerbed[i] == 0 and (i == 0 or flowerbed[i-1] == 0) and (i == len(flowerbed) -1 or flowerbed[i+1] == 0) :
                available += 1
                i += 1
                if (available >= n) :
                    return True
            if i < len(flowerbed) :
                i += flowerbed[i] + 1
            else :
                i += 1
            
        return available >= n
