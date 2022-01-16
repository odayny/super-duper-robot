class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        prev = -1
        res = 0
        for i in range(0, len(seats)) :
            if seats[i] == 1 :    
                if prev == -1 :
                    res = i
                else :
                    dist = i - prev - 1
                    res = max(res, math.ceil(dist / 2))
                prev = i
        return max(res, len(seats) - prev - 1)
            
        
