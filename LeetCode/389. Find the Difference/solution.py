class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        result = 0
        for sChar in s :
            result ^= ord(sChar)
        for tChar in t :
            result ^= ord(tChar)
        return chr(result)
        
