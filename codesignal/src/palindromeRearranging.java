/*
Given a string, find out if its characters can be rearranged to form a palindrome.

Example

For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.

Input/Output

[execution time limit] 3 seconds (java)

[input] string inputString

A string consisting of lowercase English letters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 50.

[output] boolean

true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.
*/
boolean palindromeRearranging(String inputString) {
    int[] letterCounts = new int[26];
    for (int i = 0; i < inputString.length(); i++) {
        letterCounts[inputString.charAt(i)-'a']++;
    }
    boolean oddCountMet = false;
    boolean evenOnly = inputString.length() % 2 == 0;
    for (int i = 0; i < letterCounts.length; i++) {
        if (letterCounts[i] % 2 == 1) {
            if (evenOnly || oddCountMet) {
                return false;
            } else {
                oddCountMet = true;
            }
        }
    }
    return true;
}
