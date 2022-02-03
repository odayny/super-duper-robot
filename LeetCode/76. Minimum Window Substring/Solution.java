/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
*/
class Solution {
    public String minWindow(String s, String t) {
        // fast-slow
        int fast = 1;
        int slow = 0;
        int n = s.length();
        
        // build count map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.computeIfAbsent(t.charAt(i), ch -> 0) + 1);
        }
        
        if (map.containsKey(s.charAt(0))) {
            map.put(s.charAt(0), map.get(s.charAt(0)) - 1);
        }
        
        String result = null;
        while (slow < n) {
            if (validate(map)) {
                if (result == null || fast - slow < result.length()) {
                    result = s.substring(slow, fast);
                }
                if (map.containsKey(s.charAt(slow))) {
                    map.put(s.charAt(slow), map.get(s.charAt(slow)) + 1);
                }
                slow++;
            } else if (fast < n) {
                if (map.containsKey(s.charAt(fast))) {
                    map.put(s.charAt(fast), map.get(s.charAt(fast)) - 1);
                }
                fast++;
            } else {
                break;
            }
        }
        if (result == null) {
            return "";
        } else {
            return result;
        }
    }
    
    private boolean validate(Map<Character, Integer> map) {
        for (Integer i : map.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
