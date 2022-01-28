"""
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
"""
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        """
        Let's build an array of prices for each steps. for example 1
        
        
        i mincost  explanation 
        0 10       no options to choose from
        1 15       you can go here from 0th position and cost will be 10 + 15 = 25. but going directly from beginning is cheaper
        2 30       if we go from 0th element it will be cheaper
        
        then take min from last two items, which is 15
        
        same thing for 2nd example:
        i mincost  explanation/prev step
        0 1        no other options here
        1 100      expencive but bit cheaper than going here from 0th
        2 2        0th
        3 3        2th
        4 3        2th
        5 103      3th or 4th. does not matter
        6 4        from 4th
        7 5        from 6th
        8 104.     from 6th
        9 6.       from 7th
        min(6, 104) = 6
        """
        
        # corner case first
        n = len(cost)
        if n == 2 :
            return min(cost)
        
        for i in range(2, n) :
            cost[i] += min(cost[i-1], cost[i-2])
        
        return min(cost[n-1], cost[n-2])
