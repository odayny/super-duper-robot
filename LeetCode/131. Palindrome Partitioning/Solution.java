/**
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
**/

class Solution {
    /*
    Idea here is to do a recursion:
    starting from very beginning, 1st char substring, if it's a palindrome - add it to prefix list (which will be used later for result), chop it off and run the same algo for a substring.
    if it's not a palindrome - no any reason to continue.
    */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findPartitions(new ArrayList<>(), s, result);
        return result;
    }
    
    private void findPartitions(List<String> prefix, String s, List<List<String>> result) {
        if (s.isEmpty()) {
            List<String> resItem = new ArrayList<>(prefix);
            result.add(resItem);
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            if (isPalindrome(sub)) {
                prefix.add(sub);
                findPartitions(prefix, s.substring(i+1), result);
                prefix.remove(prefix.size() - 1);
            }
        }
        
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
