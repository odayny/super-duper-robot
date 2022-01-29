"""
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
"""
class Solution:
    def sequentialDigits_bf(self, low: int, high: int) -> List[int]:
        mem = [12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,123456,234567,345678,456789,1234567,2345678,3456789,12345678,23456789,123456789]
        res = []
        for num in mem :
            if low<=num<=high :
                res.append(num)
        return res
        #18:16 2
    
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        """
        1 -> 1*10 = 10
        10 + 1 + 1 = 12
        
        2 * 10
        20 + 2 + 1 
        
        9 - pow
        
        """
        q = deque(range(1, 10))
        res = []
        
        while q :
            num = q.popleft()
            if low <= num <= high :
                res.append(num)
            if num > high :
                break
            last = num % 10
            if last < 9 :
                q.append(num * 10 + last + 1)
        return res
            
