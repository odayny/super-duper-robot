class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        sortedPoints = sorted(points, key=lambda p : p[1])
        target = sortedPoints[0][1]
        arrows = 1
        for point in sortedPoints :
            if point[0] > target :
                target = point[1]
                arrows += 1
        return arrows
        
