class Solution:
    def myAtoi(self, s: str) -> int:
        maxVal = 2**31 - 1
        minVal = -2**31
        i = 0
        res = 0
        negative = False
        n = len(s)
        while i < n and s[i] == ' ' :
            i += 1
        
        if i < n and (s[i] == '+' or s[i] == '-') :
            negative = s[i] == '-'
            i += 1
            
        while i < n and s[i].isdigit() :
            digit = int(s[i])
            if not negative and ((maxVal // 10 < res) or (maxVal // 10 == res and maxVal % 10 < digit)) :
                return maxVal
            if negative and ((-1 * minVal) // 10 < res or ((-1 * minVal)  // 10 == res and (-1 * minVal) % 10 < digit)) :
                return minVal
            res *= 10
            res += digit
            i += 1
        
        if negative :
            res *= -1
        
        return res
