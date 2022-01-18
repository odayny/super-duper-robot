class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dictionary = [0] * 26
        offset = ord('a')
        
        for c in s:
            dictionary[ord(c) - offset] += 1
        
        for c in t:
            dictionary[ord(c) - offset] -= 1
        
        for i in dictionary:
            if i != 0 :
                return False
        return True
