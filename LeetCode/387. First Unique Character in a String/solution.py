"""
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
"""
class Solution:
    def firstUniqChar_dict(self, s: str) -> int:
        """
        brute forse: pich an i-th char and run through all other (skip i-th)
            characters to see if there a repeat. if yes - go to next char, if no - 
            return true. default return - -1
        another brute force: for each lowercase English letter run a cycle 
            and count how many times it's met. if 1 - return true. if not - continue.
            default return - -1
        
        in general it's possible to find all unique chars by using a hash table in 
        form of map or array of 26 (s consists of only lowercase English letters.). 
        but how to find a __first__ one?
        
        one run to populate a map, and another - for check?
        o(n) time : we iterate through s twice
        o(1) space : constant memory (26) for any string
        
        BUT: what if we populate a hashtable from the end and save index of the last 
            not-met char somewhere
            
        example: (answer on the right; ^ - current pointer)
        loveleetcode    11   
                   ^ 
        loveleetcode    10   
                  ^ 
        loveleetcode    9   
                 ^ 
        loveleetcode    8   
                ^
        loveleetcode    7   
               ^
        loveleetcode    7 # e - already in hash table 
              ^
        loveleetcode    7 # e - already in hash table 
             ^
        loveleetcode    4
            ^
        loveleetcode    4
           ^ 
        loveleetcode    2
          ^
        loveleetcode    2 # o - already in hash table 
         ^
        loveleetcode    2 # l - already in hash table 
        ^
        
        in this case hash table may be just a set
        
        but actualluy it will never return -1
        ex:
        lolo    3
           ^
        lolo    2
          ^
        lolo    2
         ^
        lolo    2 # wrong
        ^
        
        ok. seems like those experimetns getting me nowhere. let's impl a hash table solution
        """
        
        cache = dict()
        for ch in s :
            if ch in cache :
                cache[ch] += 1
            else :
                cache[ch] = 1
                
        for i in range(len(s)) :
            if cache[s[i]] == 1 :
                return i
        
        return -1
    
    def firstUniqChar(self, s: str) -> int:
        """
        but what if?..
        """
        unique = dict()
        repeated = set()
        for i in range(len(s)) :
            if s[i] in unique :
                unique.pop(s[i])
                repeated.add(s[i])
                continue
            if s[i] in repeated :
                continue
            unique[s[i]] = i
        if unique :
            return min(unique.values())
        return -1
        
        
    
