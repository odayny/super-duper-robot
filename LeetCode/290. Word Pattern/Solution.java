/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/

/*

*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        Map<Character, String> hash = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (hash.get(pattern.charAt(i)) == null) {
                if (hash.containsValue(split[i])) {
                    return false;
                }
                hash.put(pattern.charAt(i), split[i]);
            } else if (!hash.get(pattern.charAt(i)).equals(split[i])) {
                return false;
            }
        }
        return true;
    }
}
